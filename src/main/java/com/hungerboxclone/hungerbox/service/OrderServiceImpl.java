package com.hungerboxclone.hungerbox.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerboxclone.hungerbox.dto.OrderUpdateDto;
import com.hungerboxclone.hungerbox.entities.Cart;
import com.hungerboxclone.hungerbox.entities.Customer;
import com.hungerboxclone.hungerbox.entities.FoodItem;
import com.hungerboxclone.hungerbox.entities.Order;
import com.hungerboxclone.hungerbox.exception.NoSuchCustomerException;
import com.hungerboxclone.hungerbox.exception.NoSuchOrderException;
import com.hungerboxclone.hungerbox.repo.CartRepo;
import com.hungerboxclone.hungerbox.repo.CustomerRepo;
import com.hungerboxclone.hungerbox.repo.OrderRepo;
import com.hungerboxclone.hungerbox.util.Utils;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	private static final String PLACED="Order Placed";

	@Override
	public String placeOrder(int customerId) {
		Cart cart = cartRepo.getCustomersCart(customerId);
		Customer customer = customerRepo.findById(customerId).orElseThrow(()-> new NoSuchCustomerException("Customer with id: "+customerId+" not present!!!!"));
		List<FoodItem> foodItems = cart.getFoodItems();
		Order order = new Order();
		if(foodItems != null) {
			if(customer.getOrders() == null) {
				List<Order> orderList = new ArrayList<>();
				List<FoodItem> orderItem = new ArrayList<>();
				orderItem.addAll(cart.getFoodItems());
				System.out.println("Orders:"+ orderItem);
				order.setFoodItems(orderItem);
				order.setOrderDate(Utils.parseToDateTimeToString(LocalDateTime.now()));
				orderList.add(order);
				order.setCustomer(customer);
				order.setStatus(PLACED);
				List<Double> prices = new ArrayList<>();
				
				foodItems.stream().forEach(f->{
					prices.add(f.getPrice());
				});
				
				Double totalPrice = prices.stream().reduce((double) 0,Double::sum);
				order.setTotalPrice(totalPrice);
				customer.setOrders(orderList);
				orderRepo.save(order);
				cart.setFoodItems(null);
				cartRepo.save(cart);
				customerRepo.save(customer);
			}else {
				List<Order> orderList = customer.getOrders();
				List<FoodItem> orderItem = new ArrayList<>();
				orderItem.addAll(cart.getFoodItems());
				order.setFoodItems(orderItem);
				//System.out.println("Orders:"+ orderItem);
				order.setOrderDate(Utils.parseToDateTimeToString(LocalDateTime.now()));
				orderList.add(order);
				order.setCustomer(customer);
				order.setStatus(PLACED);
				List<Double> prices = new ArrayList<>();
				
				foodItems.stream().forEach(f->{
					prices.add(f.getPrice());
				});
				
				Double totalPrice = prices.stream().reduce((double) 0,Double::sum);
				order.setTotalPrice(totalPrice);
				//customer.setOrders(orderList);

				System.out.println("FoodItems:"+ order.getFoodItems());
				orderRepo.save(order);
				cart.setFoodItems(null);
				cartRepo.save(cart);
				customerRepo.save(customer);
			}
		}
		return "Order Placed Successfully, with "+order.getFoodItems().size() +" Food Items, Total Price: "+order.getTotalPrice();
	}

	@Override
	public boolean cancelOrder(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updateOrder(OrderUpdateDto orderUpdateDto) throws NoSuchOrderException{
		Order order =orderRepo.findById(orderUpdateDto.getOrderId()).orElseThrow(()-> new NoSuchOrderException("Order with order id:"+orderUpdateDto.getOrderId()+" not found!!"));
		order.setStatus(orderUpdateDto.getStatus());
		orderRepo.save(order);
		return "Order status updated to: "+orderUpdateDto.getStatus();
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	
}

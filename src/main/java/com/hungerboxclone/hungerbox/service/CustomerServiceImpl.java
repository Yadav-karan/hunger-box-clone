package com.hungerboxclone.hungerbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerboxclone.hungerbox.dto.CustomerDto;
import com.hungerboxclone.hungerbox.entities.Cart;
import com.hungerboxclone.hungerbox.entities.Customer;
import com.hungerboxclone.hungerbox.entities.CustomerPass;
import com.hungerboxclone.hungerbox.exception.NoSuchCartException;
import com.hungerboxclone.hungerbox.exception.NoSuchCustomerException;
import com.hungerboxclone.hungerbox.repo.CartRepo;
import com.hungerboxclone.hungerbox.repo.CustomerPassRepo;
import com.hungerboxclone.hungerbox.repo.CustomerRepo;
import com.hungerboxclone.hungerbox.util.Utils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustomerPassRepo customerPassRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Override
	public Customer addCustomer(CustomerDto customerDto) {
		CustomerPass custPass = new CustomerPass(customerDto.getUsername(), customerDto.getPassword());
		customerPassRepo.save(custPass);
		return customerRepo.save(Utils.parseCustomerDtoToCustomer(customerDto));
	}

	@Override
	public boolean deleteCustomer(int customerId) throws NoSuchCustomerException{
		CustomerDto result = findCustomerById(customerId);
		if(result != null) {
			Customer customer = customerRepo.findById(customerId).
					orElseThrow(()-> new NoSuchCustomerException("Customer with id: "+customerId+" not present!!!!"));
			Cart cart = customer.getCart();
			cart.setCustomer(null);
			customer.setCart(null);
			cartRepo.delete(cart);
			customerRepo.deleteById(customerId);
			customerPassRepo.delete(customerPassRepo.findByUsername(customer.getUsername()));
			return true;
		}else {
			return false;
		}
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) throws NoSuchCustomerException {
		CustomerDto customer = findCustomerById(customerDto.getCustomerId());
		if(customer != null) {
			Customer result = customerRepo.save(Utils.parseCustomerDtoToCustomer(customerDto));
			return Utils.parseCustomerToCustomerDto(result);
		}else {
			return null;
		}
	}

	@Override
	public List<CustomerDto> getAllCustomer() {
		return Utils.parseListofCustomerToCustomerDto(customerRepo.findAll());
	}

	@Override
	public CustomerDto findCustomerById(int customerId) throws NoSuchCustomerException {
		Customer customer = customerRepo.findById(customerId).
				orElseThrow(()-> new NoSuchCustomerException("Customer with id: "+customerId+" not present!!!!"));
		return Utils.parseCustomerToCustomerDto(customer);
	}

	@Override
	public Cart findCartByCustomerId(int customerId) throws NoSuchCartException {
		Cart customersCart = cartRepo.getCustomersCart(customerId);
		if(customersCart == null) {
			throw new NoSuchCartException("Cart for customer id: "+customerId+ " not present!!!!");
		}
		return customersCart;
	}

}

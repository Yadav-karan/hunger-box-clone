package com.hungerboxclone.hungerbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hungerboxclone.hungerbox.dto.OrderUpdateDto;
import com.hungerboxclone.hungerbox.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/place-order")
	public ResponseEntity<?> placeOrder(@RequestParam int customerId){
		return new ResponseEntity<>(orderService.placeOrder(customerId),HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all-orders")
	public ResponseEntity<?> getAllOrder(){
		return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
	}
	
	@PutMapping("/update-order-status")
	public ResponseEntity<?> updateOrder(@RequestBody OrderUpdateDto orderUpdateDto){
		return new ResponseEntity<>(orderService.updateOrder(orderUpdateDto),HttpStatus.OK);
	}
}

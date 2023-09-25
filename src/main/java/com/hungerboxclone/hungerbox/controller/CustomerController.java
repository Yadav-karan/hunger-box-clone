package com.hungerboxclone.hungerbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hungerboxclone.hungerbox.dto.CustomerDto;
import com.hungerboxclone.hungerbox.entities.Order;
import com.hungerboxclone.hungerbox.exception.NoSuchCustomerException;
import com.hungerboxclone.hungerbox.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/register-customer")
	public ResponseEntity<?> registerCustomer(@RequestBody CustomerDto customerDto) {
		CustomerDto result = customerService.addCustomer(customerDto);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@GetMapping("/get-customer-by-id")
	public ResponseEntity<?> getCustomerById(@RequestParam int customerId) throws NoSuchCustomerException {
		CustomerDto customerDto = customerService.findCustomerById(customerId);
		return new ResponseEntity<>(customerDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete-customer")
	public ResponseEntity<?> deleteCustomerById(@RequestParam int customerId) throws NoSuchCustomerException {
		return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<?> getAllCustomers() {
		return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
	}

	@PutMapping("/update-customer")
	public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customerDto) {
		return new ResponseEntity<>(customerService.updateCustomer(customerDto), HttpStatus.OK);
	}

	@GetMapping("/find-customer-cart")
	public ResponseEntity<?> findCustomersCart(@RequestParam int customerId) {
		return new ResponseEntity<>(customerService.findCartByCustomerId(customerId), HttpStatus.OK);
	}

	@GetMapping("/find-customers-orders")
	public ResponseEntity<?> findCustomersOrders(@RequestParam int customerId) {
		List<Order> result = customerService.findOrdersByCustomerId(customerId);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}
}

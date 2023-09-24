package com.hungerboxclone.hungerbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hungerboxclone.hungerbox.dto.CartDto;
import com.hungerboxclone.hungerbox.exception.NoSuchCartException;
import com.hungerboxclone.hungerbox.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/add-to-cart")
	public ResponseEntity<?> addToCart(@RequestBody CartDto cartDto){
		return new ResponseEntity<>(cartService.addToCart(cartDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/get-cart")
	public ResponseEntity<?> getCarTById(@RequestParam int cartId) throws NoSuchCartException{
		return new ResponseEntity<>(cartService.getCartById(cartId),HttpStatus.OK);
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAllCart(){
		return new ResponseEntity<>(cartService.getAllCarts(),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove-all-items")
	public ResponseEntity<?> removeAllItemsFromCart(@RequestParam int cartId) throws NoSuchCartException{
		return new ResponseEntity<>(cartService.removeAllItemsFromCart(cartId),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove-item")
	public ResponseEntity<?> removeItemFromCart(@RequestParam int foodId,@RequestParam int cartId){
		return new ResponseEntity<>(cartService.removeItemFromCart(foodId, cartId),HttpStatus.OK);
	}
}

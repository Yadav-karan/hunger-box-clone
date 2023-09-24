package com.hungerboxclone.hungerbox.controller;

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

import com.hungerboxclone.hungerbox.dto.FoodDto;
import com.hungerboxclone.hungerbox.exception.NoSuchFoodException;
import com.hungerboxclone.hungerbox.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@PostMapping("/add-food")
	public ResponseEntity<?> addFood(@RequestBody FoodDto foodDto){
		return new ResponseEntity<>(foodService.addFood(foodDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all-foods")
	public ResponseEntity<?> getAllFoods(){
		return new ResponseEntity<>(foodService.getAllFood(),HttpStatus.OK);
	}
	
	@GetMapping("/get-by-id/{foodId}")
	public ResponseEntity<?> getfoodById(@RequestParam int foodId) throws NoSuchFoodException{
		return new ResponseEntity<>(foodService.getById(foodId),HttpStatus.OK);
	}
	
	@PutMapping("/update-food")
	public ResponseEntity<?> updateFood(@RequestBody FoodDto foodDto) throws NoSuchFoodException{
		return new ResponseEntity<>(foodService.updateFood(foodDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{foodId}")
	public ResponseEntity<?> deleteFood(@RequestParam int foodId) throws NoSuchFoodException{
		return new ResponseEntity<>(foodService.deleteFood(foodId),HttpStatus.OK);
	}
}

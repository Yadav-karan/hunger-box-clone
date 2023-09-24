package com.hungerboxclone.hungerbox.service;

import java.util.List;

import com.hungerboxclone.hungerbox.dto.FoodDto;
import com.hungerboxclone.hungerbox.entities.Food;
import com.hungerboxclone.hungerbox.exception.NoSuchFoodException;

public interface FoodService {
	/**
	 * will add new food to database
	 */
	FoodDto addFood(FoodDto foodDto);
	
	/**
	 * will delete food from database
	 */
	boolean deleteFood(int foodId) throws NoSuchFoodException;
	
	/**
	 * will update food in database
	 */
	FoodDto updateFood(FoodDto foodDto) throws NoSuchFoodException;
	
	/**
	 * will fetch all the foods from database
	 */
	List<FoodDto> getAllFood();
	
	/**
	 * will fetch the food from database
	 */
	FoodDto getById(int foodId) throws NoSuchFoodException;
}

package com.hungerboxclone.hungerbox.service;

import java.util.List;

import com.hungerboxclone.hungerbox.dto.FoodDto;
import com.hungerboxclone.hungerbox.entities.Food;

public interface FoodService {
	/**
	 * will add new food to database
	 */
	Food addFood(FoodDto foodDto);
	
	/**
	 * will delete food from database
	 */
	boolean deleteFood(int foodId);
	
	/**
	 * will update food in database
	 */
	Food updateFood(FoodDto foodDto);
	
	/**
	 * will fetch all the foods from database
	 */
	List<Food> getAllFood();
}

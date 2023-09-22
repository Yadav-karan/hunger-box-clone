package com.hungerboxclone.hungerbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hungerboxclone.hungerbox.dto.FoodDto;
import com.hungerboxclone.hungerbox.entities.Food;
import com.hungerboxclone.hungerbox.repo.FoodRepo;
import com.hungerboxclone.hungerbox.util.Utils;

public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepo foodRepo;
	
	@Override
	public Food addFood(FoodDto foodDto) {
		return foodRepo.save(Utils.parseFoodDtoToFood(foodDto));
	}

	@Override
	public boolean deleteFood(int foodId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Food updateFood(FoodDto foodDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> getAllFood() {
		// TODO Auto-generated method stub
		return null;
	}

}

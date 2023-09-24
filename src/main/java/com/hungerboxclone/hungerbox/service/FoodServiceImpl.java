package com.hungerboxclone.hungerbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerboxclone.hungerbox.dto.FoodDto;
import com.hungerboxclone.hungerbox.entities.Food;
import com.hungerboxclone.hungerbox.exception.NoSuchFoodException;
import com.hungerboxclone.hungerbox.repo.FoodRepo;
import com.hungerboxclone.hungerbox.util.Utils;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepo foodRepo;
	
	@Override
	public FoodDto addFood(FoodDto foodDto) {
		Food food = foodRepo.save(Utils.parseFoodDtoToFood(foodDto));
		return Utils.parseFoodToFoodDto(food);
	}

	@Override
	public boolean deleteFood(int foodId) throws NoSuchFoodException{
		FoodDto foodDto = getById(foodId);
		if(foodDto != null) {
			foodRepo.deleteById(foodDto.getFoodId());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public FoodDto updateFood(FoodDto foodDto) throws NoSuchFoodException {
		FoodDto result = getById(foodDto.getFoodId());
		if(result != null) {
			Food food = foodRepo.save(Utils.parseFoodDtoToFood(foodDto));
			return Utils.parseFoodToFoodDto(food);
		}
		return null;
	}

	@Override
	public List<FoodDto> getAllFood() {
		return Utils.parseListOfFoodToListOfFoodDto(foodRepo.findAll());
	}

	@Override
	public FoodDto getById(int foodId) throws NoSuchFoodException {
		Food food = foodRepo.findById(foodId).orElseThrow(()-> new NoSuchFoodException("Food with id "+foodId+" not present!!!!"));
		return Utils.parseFoodToFoodDto(food);
	}

}

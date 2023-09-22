package com.hungerboxclone.hungerbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungerboxclone.hungerbox.entities.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {

}

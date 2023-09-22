package com.hungerboxclone.hungerbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungerboxclone.hungerbox.entities.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

}

package com.hungerboxclone.hungerbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hungerboxclone.hungerbox.entities.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

	@Query("SELECT c FROM Cart c WHERE c.customer.customerId =?1")
	Cart getCustomersCart(int customerId);
}

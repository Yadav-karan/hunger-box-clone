package com.hungerboxclone.hungerbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungerboxclone.hungerbox.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}

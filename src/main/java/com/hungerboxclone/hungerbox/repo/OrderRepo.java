package com.hungerboxclone.hungerbox.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hungerboxclone.hungerbox.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

	@Query("SELECT o FROM Order o WHERE o.customer.customerId =?1")
	List<Order> getCustomersOrders(int customerId);
}

package com.hungerboxclone.hungerbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungerboxclone.hungerbox.entities.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}

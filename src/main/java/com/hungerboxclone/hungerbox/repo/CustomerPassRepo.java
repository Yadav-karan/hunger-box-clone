package com.hungerboxclone.hungerbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungerboxclone.hungerbox.entities.CustomerPass;

@Repository
public interface CustomerPassRepo extends JpaRepository<CustomerPass, String> {

}

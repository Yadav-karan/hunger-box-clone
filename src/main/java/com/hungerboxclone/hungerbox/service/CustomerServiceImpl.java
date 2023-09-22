package com.hungerboxclone.hungerbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerboxclone.hungerbox.dto.CustomerDto;
import com.hungerboxclone.hungerbox.entities.Customer;
import com.hungerboxclone.hungerbox.entities.CustomerPass;
import com.hungerboxclone.hungerbox.exception.NoSuchCustomerException;
import com.hungerboxclone.hungerbox.repo.CustomerPassRepo;
import com.hungerboxclone.hungerbox.repo.CustomerRepo;
import com.hungerboxclone.hungerbox.util.Utils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustomerPassRepo customerPassRepo;
	
	@Override
	public Customer addCustomer(CustomerDto customerDto) {
		CustomerPass custPass = new CustomerPass(customerDto.getUsername(), customerDto.getPassword());
		customerPassRepo.save(custPass);
		return customerRepo.save(Utils.parseCustomerDtoToCustomer(customerDto));
	}

	@Override
	public boolean deleteCustomer(int customerId) throws NoSuchCustomerException{
		Customer customer = findCustomerById(customerId);
		if(customer != null) {
			customerRepo.deleteById(customerId);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Customer updateCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerById(int customerId) throws NoSuchCustomerException {
		Customer customer = customerRepo.findById(customerId).
				orElseThrow(()-> new NoSuchCustomerException("Customer with id: "+customerId+" not present!!!!"));
		return customer;
	}

}

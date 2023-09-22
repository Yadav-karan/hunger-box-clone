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
		CustomerDto customer = findCustomerById(customerId);
		if(customer != null) {
			customerRepo.deleteById(customerId);
			customerPassRepo.delete(customerPassRepo.findByUsername(customer.getUsername()));
			return true;
		}else {
			return false;
		}
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) throws NoSuchCustomerException {
		CustomerDto customer = findCustomerById(customerDto.getCustomerId());
		if(customer != null) {
			Customer result = customerRepo.save(Utils.parseCustomerDtoToCustomer(customerDto));
			return Utils.parseCustomerToCustomerDto(result);
		}else {
			return null;
		}
	}

	@Override
	public List<CustomerDto> getAllCustomer() {
		return Utils.parseListofCustomerToCustomerDto(customerRepo.findAll());
	}

	@Override
	public CustomerDto findCustomerById(int customerId) throws NoSuchCustomerException {
		Customer customer = customerRepo.findById(customerId).
				orElseThrow(()-> new NoSuchCustomerException("Customer with id: "+customerId+" not present!!!!"));
		return Utils.parseCustomerToCustomerDto(customer);
	}

}

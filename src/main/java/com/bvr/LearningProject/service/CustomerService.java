package com.bvr.LearningProject.service;

import com.bvr.LearningProject.model.Address;
import com.bvr.LearningProject.model.Customer;
import com.bvr.LearningProject.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    public Customer saveAddress(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }
}

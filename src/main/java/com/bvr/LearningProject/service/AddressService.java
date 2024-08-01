package com.bvr.LearningProject.service;

import com.bvr.LearningProject.model.Address;
import com.bvr.LearningProject.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    public Address getAddressById(Long id) {
        return addressRepo.findById(id).orElse(null);
    }

    public List<Address> getAllAddress(){
        return addressRepo.findAll();
    }
}

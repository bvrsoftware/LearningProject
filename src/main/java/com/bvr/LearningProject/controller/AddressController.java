package com.bvr.LearningProject.controller;

import com.bvr.LearningProject.model.Address;
import com.bvr.LearningProject.model.Authority;
import com.bvr.LearningProject.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "address")
public class AddressController {
    @Autowired
    private AddressService addressService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveAddress(@RequestBody Address address) {
        Address saveAddress = addressService.saveAddress(address);
        if (saveAddress != null) {
            return new ResponseEntity<>("Save Authority Successfully with id : " + saveAddress.getId(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("unsuccessfully! ", HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAddresses() {
        List<Address> allAddresses = addressService.getAllAddress();
        if (allAddresses != null && !allAddresses.isEmpty()) {
            return new ResponseEntity<>(allAddresses, HttpStatus.OK);
        }
        return new ResponseEntity<>("No Authority available now !!!! ", HttpStatus.CONFLICT);
    }
}

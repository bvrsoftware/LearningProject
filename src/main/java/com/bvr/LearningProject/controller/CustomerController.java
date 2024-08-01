package com.bvr.LearningProject.controller;

import com.bvr.LearningProject.model.Customer;
import com.bvr.LearningProject.service.AddressService;
import com.bvr.LearningProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> saveAuthority(@RequestBody Customer customer){
        Customer saveCustomer = customerService.saveAddress(customer);
        if (saveCustomer!=null){
            return new ResponseEntity<>("Save Customer Successfully with id : "+saveCustomer.getId(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("unsuccessfully! ", HttpStatus.CONFLICT);
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers(){
        List<Customer> allCustomer = customerService.getAllCustomer();
        if (allCustomer!=null&&!allCustomer.isEmpty()){
            return new ResponseEntity<>(allCustomer,HttpStatus.OK);
        }
        return new ResponseEntity<>("No Customer available now !!!! ", HttpStatus.CONFLICT);
    }
}

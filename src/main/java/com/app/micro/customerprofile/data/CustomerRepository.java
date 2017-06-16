package com.app.micro.customerprofile.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.micro.customerprofile.mongodb.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
    
    Customer findById(Integer id);

}
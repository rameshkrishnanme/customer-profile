package com.app.micro.customerprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.micro.customerprofile.contants.Constants;
import com.app.micro.customerprofile.data.CustomerRepository;
import com.app.micro.customerprofile.data.NextSequenceService;
import com.app.micro.customerprofile.domain.Customer;

@RestController
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    NextSequenceService nextSequenceService;

    public CustomerService() {
        super();

    }

    @RequestMapping(value = "/Customer", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public Customer createCustomer(@RequestBody Customer customer) {
        com.app.micro.customerprofile.mongodb.entity.Customer customer2 = Customer.createMongoObject(customer);
        customer2.setId(nextSequenceService.getNextSequence(Constants.CUSTOMER_PROFILE_SEQUENCE.toString()));
        customerRepository.save(customer2);
        Customer newCustomer = Customer.createObject(customer2);
        return newCustomer;
    }

    @RequestMapping(value = "/Customer/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public Customer findCustomer(@PathVariable(value = "id") String identifier) {
        final com.app.micro.customerprofile.mongodb.entity.Customer customerMongo = customerRepository.findById(Integer
            .valueOf(identifier));
        Customer customer = Customer.createObject(customerMongo);
        return customer;
    }

    protected void _log(String s) {
        System.out.println(s);
    }
}
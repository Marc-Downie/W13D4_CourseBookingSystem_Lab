package com.example.CourseBookingSystem.controllers;

import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "courseName") String courseName,
            @RequestParam(required = false, name = "courseTown") String courseTown,
            @RequestParam(required = false, name = "age") Integer age
    ){
        if(name != null) {
            return new ResponseEntity(customerRepository.findCustomerByBookingsCourseName(name), HttpStatus.OK);
        }
        if(courseName != null && courseTown != null){
            List<Customer> foundCustomer = customerRepository.findCustomerByBookingsCourseNameAndBookingsCourseTown(courseName, courseTown);
            return new ResponseEntity(foundCustomer, HttpStatus.OK);
        }
        if(age != null && courseTown != null) {
            List<Customer> foundCustomer = customerRepository.findCustomerByAgeGreaterThanAndBookingsCourseTown(age, courseTown);
            return new ResponseEntity(foundCustomer, HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer, @PathVariable Long id){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity <List<Customer>> deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}

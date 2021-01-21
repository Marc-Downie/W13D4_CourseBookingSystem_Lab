package com.example.CourseBookingSystem.repositories;

import com.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByBookingsCourseName(String name);

    List<Customer> findCustomerByBookingsCourseNameAndBookingsCourseTown(String name, String town);

    List<Customer> findCustomerByAgeGreaterThanAndBookingsCourseTown(int age, String town);
}

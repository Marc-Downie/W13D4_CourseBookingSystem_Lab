package com.example.CourseBookingSystem.components;

import com.example.CourseBookingSystem.models.Booking;
import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.BookingRepository;
import com.example.CourseBookingSystem.repositories.CourseRepository;
import com.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments arg) {

        Course course1 = new Course("Intro to Python", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Intro to Spring", "Glasgow", 1);
        courseRepository.save(course2);

        Course course3 = new Course("Intro to Ruby", "Edinburgh", 1);
        courseRepository.save(course3);

        Customer customer1 = new Customer("Marc", "Edinburgh", 32);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Mateusz", "Edinburgh", 33);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("John", "Aberdeen", 55);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("21-01-21", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("21-01-21", course1, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("01-01-22", course2, customer3);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking( "30-05-19", course1, customer3);
        bookingRepository.save(booking4);

    }

}

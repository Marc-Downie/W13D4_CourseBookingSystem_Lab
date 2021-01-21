package com.example.CourseBookingSystem;

import com.example.CourseBookingSystem.models.Booking;
import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.BookingRepository;
import com.example.CourseBookingSystem.repositories.CourseRepository;
import com.example.CourseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindByStarRating() {
		List<Course> foundCourses = courseRepository.findByStarRating(5);
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void canFindCustomerByBookingsCourseName() {
		List<Customer> foundCustomer = customerRepository.findCustomerByBookingsCourseName("Intro to Python");
		assertEquals(3, foundCustomer.size());
	}

	@Test
	public void canFindCourseByBookingsCustomerName() {
		List<Course> foundCourses = courseRepository.findCourseByBookingsCustomerName("John");
		assertEquals(2, foundCourses.size());
	}

	@Test
	public void canFindBookingByDate(){
		List<Booking> foundBookings = bookingRepository.findBookingByDate("21-01-21");
		assertEquals(2, foundBookings.size());
	}

	@Test
	public void canFindCustomerByBookingsCourseNameAndBookingsCourseTown() {
		List<Customer> foundCustomers = customerRepository.findCustomerByBookingsCourseNameAndBookingsCourseTown("Intro to Python", "Edinburgh");
		assertEquals(3, foundCustomers.size());
	}

	@Test
	public void canFindCustomerByAgeAndBookingsCourseTown(){
		List<Customer> foundCustomers = customerRepository.findCustomerByAgeGreaterThanAndBookingsCourseTown(32, "Edinburgh");
		assertEquals(2, foundCustomers.size());
	}

}

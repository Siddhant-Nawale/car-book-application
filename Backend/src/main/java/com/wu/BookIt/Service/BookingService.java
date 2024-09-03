package com.wu.BookIt.Service;

import java.util.List;

import com.wu.BookIt.entity.Booking;
import com.wu.BookIt.entity.Employee;

public interface BookingService {

	public Booking book(int cabNo, int numOfSeats);

	public Booking bookWithPlace(String place, int numOfSeats);

	public List<Employee> bookWithEmployees(int cabNo, int numOfSeats, List<Integer> empNos);

}

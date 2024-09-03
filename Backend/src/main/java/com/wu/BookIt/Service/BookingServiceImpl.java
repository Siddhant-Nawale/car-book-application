package com.wu.BookIt.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wu.BookIt.Exception.CabNotAvailableException;
import com.wu.BookIt.Exception.CabNotFoundException;
import com.wu.BookIt.Exception.EmployeeNotFoundException;
import com.wu.BookIt.Exception.SeatNotAvailableException;
import com.wu.BookIt.Repo.BookingRepo;
import com.wu.BookIt.Repo.CabRepo;
import com.wu.BookIt.Repo.EmployeeRepo;
import com.wu.BookIt.constants.Constants;
import com.wu.BookIt.entity.Booking;
import com.wu.BookIt.entity.Cab;
import com.wu.BookIt.entity.Employee;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	CabRepo cabRepo;
	@Autowired
	BookingRepo bookingRepo;
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Booking bookWithPlace(String place, int numOfSeats) {
		// TODO Auto-generated method stub
		// get one cab with sufficient available seats and going through that place
		Cab cab = cabRepo.findFirstByNumberOfSeatsBookedLessThanEqualAndRouteContaining(
				Constants.MAXIMUM_NUMBER_OF_PEOPLE_PER_CAB - numOfSeats, place);
		if (cab == null) {
			throw new CabNotAvailableException("All cabs booked");
		}

		cab.setNumberOfSeatsBooked(cab.getNumberOfSeatsBooked() + numOfSeats);
		Booking booking = new Booking(cab.getCabNo(), cab.getNextAvailableAt(), numOfSeats);
		bookingRepo.save(booking);
		if (cab.getNumberOfSeatsBooked() >= Constants.MAXIMUM_NUMBER_OF_PEOPLE_PER_CAB) {
			cab.incrementAvailableTime();
		}
		cabRepo.save(cab);
		return booking;
	}

	@Override
	public Booking book(int cabNo, int numOfSeats) {
		// TODO Auto-generated method stub
		Cab cab = cabRepo.findById(cabNo)
				.orElseThrow(() -> new CabNotFoundException("Cab with ID " + cabNo + " not found"));

		// Check if enough seats are available
		if (numOfSeats > (4 - cab.getNumberOfSeatsBooked())) {
			throw new SeatNotAvailableException("Not enough seats available to book " + numOfSeats + " seats.");
		}

		// Create a new booking
		Booking booking = new Booking();
		booking.setCabNumber(cabNo);
		booking.setCabTime(cab.getNextAvailableAt());
		booking.setNumberOfSeat(numOfSeats);

		int updatedSeatsBooked = cab.getNumberOfSeatsBooked() + numOfSeats;
		cab.setNumberOfSeatsBooked(updatedSeatsBooked);

		if (updatedSeatsBooked == 4) {
			cab.incrementAvailableTime();
			cab.setNumberOfSeatsBooked(0);
		}

		cabRepo.save(cab);
		bookingRepo.save(booking);

		return booking;

	}

	@Override
	public List<Employee> bookWithEmployees(int cabNo, int numOfSeats, List<Integer> empNos) {
		Cab cab = cabRepo.findById(cabNo)
				.orElseThrow(() -> new CabNotFoundException("Cab with ID " + cabNo + " not found"));

		// Check if enough seats are available
		if (numOfSeats > (4 - cab.getNumberOfSeatsBooked())) {
			throw new SeatNotAvailableException("Not enough seats available to book " + numOfSeats + " seats.");
		}

		// Create a new booking
		Booking booking = new Booking();
		booking.setCabNumber(cabNo);
		booking.setCabTime(cab.getNextAvailableAt());
		booking.setNumberOfSeat(numOfSeats);

		int updatedSeatsBooked = cab.getNumberOfSeatsBooked() + numOfSeats;
		cab.setNumberOfSeatsBooked(updatedSeatsBooked);

		if (updatedSeatsBooked == 4) {
			cab.incrementAvailableTime();
//			cab.setNumberOfSeatsBooked(0);
		}
		List<Employee> employees = new ArrayList();
		empNos.forEach((e) -> {
			Employee employee = employeeRepo.findById(e)
					.orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist"));
			employee.setBookedCab(cab);
			employeeRepo.save(employee);
			employees.add(employee);
		});

		cabRepo.save(cab);
		bookingRepo.save(booking);

		return employees;
	}

}

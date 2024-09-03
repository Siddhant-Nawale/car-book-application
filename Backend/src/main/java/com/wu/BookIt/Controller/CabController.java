package com.wu.BookIt.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.BookIt.Service.BookingService;
import com.wu.BookIt.Service.CabService;
import com.wu.BookIt.entity.Booking;
import com.wu.BookIt.entity.Cab;
import com.wu.BookIt.entity.Employee;

@RestController
@RequestMapping("cab")
@CrossOrigin(origins = "*")
public class CabController {
	@Autowired
	CabService cabService;

	@Autowired
	BookingService bookingService;

	// Create Cab
	@PostMapping()
	public ResponseEntity<Cab> createCab(@RequestBody Cab cab) {

		Cab savedCab = cabService.createCab(cab);
		return ResponseEntity.ok().body(savedCab);
	}

	// Get All Cabs
	@GetMapping("cabs")
	public ResponseEntity<List<Cab>> getAllCabs() {
		List<Cab> cabs = cabService.getAllCabs();

		return ResponseEntity.ok().body(cabs);
	}

	// Get Cabs by cabNumber
	@GetMapping("{cabNo}")
	public ResponseEntity<Cab> getCabByCabNumber(@PathVariable("cabNo") int cabNo) {
		Cab cab = cabService.getCabByCabNumber(cabNo);
		return ResponseEntity.ok().body(cab);
	}

	// get available cabs
	@GetMapping("available")
	public ResponseEntity<List<Cab>> getAvailableCab() {
		List<Cab> cabs = cabService.getAllAvailableCabs();
		return ResponseEntity.ok().body(cabs);
	}

	// get booked cabs
	@GetMapping("booked")
	public ResponseEntity<List<Cab>> getBookedCab() {
		List<Cab> cabs = cabService.getAllBookedCabs();
		return ResponseEntity.ok().body(cabs);
	}

	// get cabs going to x place
	@GetMapping("place/{place}")
	public ResponseEntity<List<Cab>> getCabsWithPlace(@PathVariable String place) {
		List<Cab> cabs = cabService.getCabsWithPlace(place);
		return ResponseEntity.ok().body(cabs);
	}

	// get cabs going to x place with available cabs
	@GetMapping("place/{place}/{noOfSeats}")
	public ResponseEntity<List<Cab>> getCabsWithPlaceWithNumberOfSeats(@PathVariable String place,
			@PathVariable int noOfSeats) {
		List<Cab> cabs = cabService.getCabsWithPlaceAndNoOfSeats(place, noOfSeats);
		return ResponseEntity.ok().body(cabs);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Map<String, String>> deleteCab(@PathVariable int id) {
		Boolean deleted = cabService.deleteCab(id);
		if (deleted)
			return ResponseEntity.ok().body(Map.of("message", "Cab with id: " + id + " deleted"));
		return ResponseEntity.ok().body(Map.of("message", "Cab with id: " + id + " not deleted"));
	}

	@PutMapping()
	public ResponseEntity<Cab> updatCab(@RequestBody Cab cab) {
		Cab updatedCab = cabService.updateCab(cab);
		return ResponseEntity.ok().body(updatedCab);

	}

	@PutMapping("book/place/{place}/{numOfSeats}")
	public ResponseEntity<Booking> bookCabWithPlace(@PathVariable String place, @PathVariable int numOfSeats) {
		Booking booking = bookingService.bookWithPlace(place, numOfSeats);
		return ResponseEntity.ok().body(booking);
	}

	@PutMapping("book/{cabNo}/{numOfSeats}")
	public ResponseEntity<Booking> bookCab(@PathVariable int cabNo, @PathVariable int numOfSeats) {
		Booking booking = bookingService.book(cabNo, numOfSeats);
		return ResponseEntity.ok().body(booking);
	}

	@PostMapping("book/{cabNo}/{numOfSeats}")
	public ResponseEntity<List<Employee>> bookCabWithEmployee(@PathVariable int cabNo, @PathVariable int numOfSeats,
			@RequestBody Map<String, List<Integer>> requestBody) {
		List<Integer> empNos = requestBody.get("empNos");
		System.out.println(empNos);
		 List<Employee> employees = bookingService.bookWithEmployees(cabNo, numOfSeats,empNos);
		return ResponseEntity.ok().body(employees);
	}

}

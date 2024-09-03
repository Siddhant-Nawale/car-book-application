package com.wu.BookIt.Service;

import java.util.List;

import com.wu.BookIt.entity.Cab;

public interface CabService {

	public Cab createCab(Cab cab);

	public List<Cab> getAllCabs();

	public Cab getCabByCabNumber(int cabNo);

	public List<Cab> getAllAvailableCabs();

	public List<Cab> getAllBookedCabs();

	public List<Cab> getCabsWithPlace(String place);

	public Boolean deleteCab(int id);

	public Cab updateCab(Cab cab);
 
	public List<Cab> getCabsWithPlaceAndNoOfSeats(String place, int noOfSeats);

}

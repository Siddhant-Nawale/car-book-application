package com.wu.BookIt.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wu.BookIt.Exception.CabAlreadyBookedException;
import com.wu.BookIt.Exception.CabNotFoundException;
import com.wu.BookIt.Repo.CabRepo;
import com.wu.BookIt.constants.Constants;
import com.wu.BookIt.entity.Cab;

@Service
public class CabServiceImpl implements CabService {

	@Autowired
	CabRepo repo;

	// Create cab
	@Override
	public Cab createCab(Cab cab) {
		repo.save(cab);
		return cab;
	}

	// Get All Cabs
	@Override
	public List<Cab> getAllCabs() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Cab getCabByCabNumber(int cabNo) {
		// TODO Auto-generated method stub
		return repo.findById(cabNo)
				.orElseThrow(() -> new CabNotFoundException("Can with available number " + cabNo + " not Found"));
	}

	@Override
	public List<Cab> getAllAvailableCabs() {
		// TODO Auto-generated method stub
		return repo.findByNumberOfSeatsBookedLessThan(Constants.MAXIMUM_NUMBER_OF_PEOPLE_PER_CAB);
	}

	@Override
	public List<Cab> getAllBookedCabs() {
		// TODO Auto-generated method stub
		return repo.findByNumberOfSeatsBookedGreaterThanEqual(Constants.MAXIMUM_NUMBER_OF_PEOPLE_PER_CAB);
	}

	@Override
	public List<Cab> getCabsWithPlace(String place) {
		// TODO Auto-generated method stub
		return repo.findByRouteContaining(place);
	}

	@Override
	public Boolean deleteCab(int id) {
		// TODO Auto-generated method stub
		Cab cab = repo.findById(id).orElseThrow(() -> new CabNotFoundException("Cab with this id doesnot exist"));

		if (cab.getNumberOfSeatsBooked() == 0) {
			repo.deleteById(id);
			return true;
		}
		throw new CabAlreadyBookedException("Cab is already booked and cannot be deleted");
	}

	@Override
	public Cab updateCab(Cab cab) {
		// TODO Auto-generated method stub
		repo.findById(cab.getCabNo()).orElseThrow(() -> new CabNotFoundException("Cab with this id doesnot exist"));
		return repo.save(cab);
	}

	@Override
	public List<Cab> getCabsWithPlaceAndNoOfSeats(String place, int noOfSeats) {
		// TODO Auto-generated method stub
		return repo.findByNumberOfSeatsBookedLessThanEqualAndRouteContaining(4 - noOfSeats, place);
	}
}

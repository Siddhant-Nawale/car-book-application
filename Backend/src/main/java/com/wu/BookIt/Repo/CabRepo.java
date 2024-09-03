package com.wu.BookIt.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wu.BookIt.entity.Cab;

public interface CabRepo extends JpaRepository<Cab, Integer> {

	List<Cab> findByNumberOfSeatsBookedLessThan(int n);
//	@Query("SELECT c FROM Cab c WHERE c.numberOfSeatsBooked < :n AND c.route LIKE %:str% limit 1")
	Cab findFirstByNumberOfSeatsBookedLessThanEqualAndRouteContaining(int n, String str);
	List<Cab> findByNumberOfSeatsBookedGreaterThanEqual(int n);
	List<Cab> findByRouteContaining(String str); 

	List<Cab> findByNumberOfSeatsBookedLessThanEqualAndRouteContaining(int n, String str);
}

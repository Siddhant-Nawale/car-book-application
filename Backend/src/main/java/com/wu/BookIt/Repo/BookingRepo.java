package com.wu.BookIt.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wu.BookIt.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

}

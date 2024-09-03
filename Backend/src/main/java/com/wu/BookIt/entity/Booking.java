package com.wu.BookIt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Student
 *
 */
@Entity
@Table(name = "BOOKING")
public class Booking {
	@Id
	@Column(name = "BOOKING_NUMBER")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingNumber;
	
	@Column(name="CAB_NUMBER")
	private int cabNumber;
	
//	@ManyToOne
//    @JoinColumn(name = "CAB_NUMBER")
//    private Cab cab;
	
	@Column(name="CAB_TIME")
	private int cabTime;
	
	@Column(name="NUMBER_OF_SEAT")
	private int numberOfSeat;

	
	// method

	public Booking(  int cabNumber, int cabTime, int numberOfSeat) {
		super();
//		this.bookingNumber = bookingNumber;
		this.cabNumber = cabNumber;
		this.cabTime = cabTime;
		this.numberOfSeat = numberOfSeat;
	}
	
	public Booking() {
		super();
	}

	public int getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public int getCabNumber() {
		return cabNumber;
	}

	public void setCabNumber(int cabNumber) {
		this.cabNumber = cabNumber;
	}

	public int getCabTime() {
		return cabTime;
	}

	public void setCabTime(int cabTime) {
		this.cabTime = cabTime;
	}

	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	@Override
	public String toString() {
		return "Booking [bookingNumber=" + bookingNumber + ", cabNumber=" + cabNumber + ", cabTime=" + cabTime
				+ ", numberOfSeat=" + numberOfSeat + "]";
	}
	
}

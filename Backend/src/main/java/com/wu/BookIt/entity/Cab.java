package com.wu.BookIt.entity;

import com.wu.BookIt.Exception.ADayOnlyHas24HoursException;
import com.wu.BookIt.Exception.CannotBookMoreThanMaximumAllowedLimitException;
import com.wu.BookIt.constants.Constants;

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
@Table(name = "CAB")
public class Cab {
	@Id
	@Column(name = "CABNO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cabNo;

	@Column(name = "ROUTE")
	private String route;

	@Column(name = "NEXT_AVAIALABLE_AT")
	private int nextAvailableAt;

	@Column(name = "NUMBER_OF_SEATS_BOOKED")
	private int numberOfSeatsBooked;

	// methods

	public Cab(String route, int nextAvailableAt, int numberOfSeatsBooked) {
		super();
		setRoute(route); 
		setNextAvailableAt(nextAvailableAt);
		setNumberOfSeatsBooked(numberOfSeatsBooked);
	}

	public Cab() {
		super();
	}

	public int getCabNo() {
		return cabNo;
	}

	public void setCabNo(int cabNo) {
		this.cabNo = cabNo;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public int getNextAvailableAt() {
		return nextAvailableAt;
	}

	public void setNextAvailableAt(int nextAvailableAt) {
		if (nextAvailableAt > Constants.MAXIMUM_HOUR_IN_A_DAY) {
			throw new ADayOnlyHas24HoursException(nextAvailableAt+" hour does not exist in a day");
		}
		this.nextAvailableAt = nextAvailableAt;
	}

	public int getNumberOfSeatsBooked() {

		return numberOfSeatsBooked;
	}

	public void setNumberOfSeatsBooked(int numberOfSeatsBooked) {
		if (numberOfSeatsBooked > Constants.MAXIMUM_NUMBER_OF_PEOPLE_PER_CAB) {
			throw new CannotBookMoreThanMaximumAllowedLimitException("Fully Booked");
		}
		this.numberOfSeatsBooked = numberOfSeatsBooked;
	}

	@Override
	public String toString() {
		return "Cab [cabNo=" + cabNo + ", route=" + route + ", nextAvailableAt=" + nextAvailableAt
				+ ", numberOfSeatsBooked=" + numberOfSeatsBooked + "]";
	}

	public void incrementAvailableTime() {
		// TODO Auto-generated method stub
		if (this.nextAvailableAt >= 24) {
			this.nextAvailableAt = 0;
		}
		this.nextAvailableAt += 1;
	}

}

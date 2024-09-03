package com.wu.BookIt.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Student
 *
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@Column(name = "EMPLOYEEID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS")
	private String address;

	@ManyToOne(cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "CAB_NUMBER")
	private Cab bookedCab;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name,String address, Cab bookedCab) {
		super();
		this.name = name;
		this.address = address;
		this.bookedCab = bookedCab;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Cab getBookedCab() {
		return bookedCab;
	}

	public void setBookedCab(Cab bookedCab) {
		this.bookedCab = bookedCab;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", bookedCab=" + bookedCab
				+ "]";
	}

}

package com.cg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Column
	private String customerName;
	
	@Id
	@Column(name="mobile_no")
	private String customerMobileNo;
	
	@Column
	private float customerAge;
	
	@Column(name="init_bal")
	private double customerInitialBalance;
	
	public Customer() {
		super();
	}

	public Customer(String name, String mobileNo, float age,
			double initialBalance) {
		super();
		this.customerName = name;
		this.customerMobileNo = mobileNo;
		this.customerAge = age;
		this.customerInitialBalance = initialBalance;
	}

	public String getName() {
		return customerName;
	}

	public void setName(String name) {
		this.customerName = name;
	}

	public String getMobileNo() {
		return customerMobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.customerMobileNo = mobileNo;
	}

	public float getAge() {
		return customerAge;
	}

	public void setAge(float age) {
		this.customerAge = age;
	}

	public double getInitialBalance() {
		return customerInitialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.customerInitialBalance = initialBalance;
	}	
	
	
}

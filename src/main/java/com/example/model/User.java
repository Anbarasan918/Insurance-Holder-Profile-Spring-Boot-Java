package com.example.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="age")
	private String age;
	
	@Column(name="location")
	private String location;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="designation")
	private String designation;
	
	
	@Column(name="address")
	private String address;
	
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="sumOfInsuranceAmount")
	private int sumOfInsuranceAmount;
	
	@Column(name="insurancePlan")
	private String insurancePlan;
	
}

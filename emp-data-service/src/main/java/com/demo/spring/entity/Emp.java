package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="EMP")
@XmlRootElement
public class Emp {

	@Id
	@Column(name="EMPNO")
	@NotNull
	private int empId;
	
	@Column(name="NAME")
	@NotNull
	@Size(min = 5)
	private String name;
	
	@Column(name="ADDRESS")
	@NotNull
	@Size(min=2)
	private String city;
	
	@Column(name="SALARY")
	private double salary;
	
	public Emp() {
		
	}
	
	public Emp(int empId, String name, String city, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.salary = salary;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}

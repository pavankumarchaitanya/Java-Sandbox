package com.company;

import java.util.List;

/**
 * @author pavankumar.l
 *
 */
public class Employee {
	String name;
	Integer id;
	Integer rating;
	Integer salary;
	List<Employee> reportingEmployeeList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public List<Employee> getReportingEmployeeList() {
		return reportingEmployeeList;
	}

	public void setReportingEmployeeList(List<Employee> reportingEmployeeList) {
		this.reportingEmployeeList = reportingEmployeeList;
	}

}

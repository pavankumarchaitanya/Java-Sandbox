package com.organization.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.company.Employee;
import com.organization.selection.criteria.RatingComparator;
import com.organization.selection.criteria.SalaryComparator;
import com.organization.selection.util.EmployeeSelectorUtil;

/**
 * @author pavankumar.l
 *
 */
public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> reportingEmployeeList = new ArrayList<Employee>();

		Employee E6 = new Employee();

		E6.setId(6);
		E6.setName("6");
		E6.setRating(2);
		E6.setReportingEmployeeList(null);
		E6.setSalary(40000);

		Employee E7 = new Employee();

		E7.setId(7);
		E7.setName("7");
		E7.setRating(2);
		E7.setReportingEmployeeList(null);
		E7.setSalary(20000);
		reportingEmployeeList = new ArrayList<Employee>();

		reportingEmployeeList.add(E6);
		reportingEmployeeList.add(E7);

		Employee E3 = new Employee();

		E3.setId(3);
		E3.setName("3");
		E3.setRating(4);
		E3.setReportingEmployeeList(reportingEmployeeList); // e6 and e7 are
															// added to e3
		E3.setSalary(30000);
		ArrayList<Comparator<Employee>> selectionCriteriaList = new ArrayList<Comparator<Employee>>();

		RatingComparator r = new RatingComparator();
		SalaryComparator s = new SalaryComparator();
		selectionCriteriaList.add(r);
		selectionCriteriaList.add(s);
		System.out.println("Selected Employee IDs : ");
		for (Employee E : EmployeeSelectorUtil.selectXPercentageEmployeesUnder(
				E3, selectionCriteriaList, 50)) {
			System.out.println(E.getId());
		}

	}

}

package com.organization.selection.criteria;

import java.util.Comparator;

import com.company.Employee;

public class RatingComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {

		if (o1.getRating() < o2.getRating()) {
			return 1;

		} else if (o1.getRating() > o2.getRating()) {
			return -1;
		} else
			return 0;
	}

}

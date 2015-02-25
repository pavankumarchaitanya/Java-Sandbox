package com.organization.selection.criteria;

import java.util.Comparator;

import com.company.Employee;

/**
 * @author pavankumar.l
 *
 */
public class Criteria implements Comparator<Employee> {

	Criteria SecondaryCriteria = null;
	Comparator<Employee> primaryComparator = null;
	@Override
	public int compare(Employee o1, Employee o2) {
		
		if(primaryComparator!=null && primaryComparator.compare(o1, o2)!=0)
			return primaryComparator.compare(o1, o2);
		else
			if(SecondaryCriteria!=null && SecondaryCriteria.compare(o1, o2)!=0)
				return SecondaryCriteria.compare(o1, o2);
			else
		return 0;

	}
	public Criteria getSecondaryCriteria() {
		return SecondaryCriteria;
	}
	public void setSecondaryCriteria(Criteria secondaryCriteria) {
		SecondaryCriteria = secondaryCriteria;
	}
	public Comparator<Employee> getPrimaryComparator() {
		return primaryComparator;
	}
	public void setPrimaryComparator(Comparator<Employee> primaryComparator) {
		this.primaryComparator = primaryComparator;
	}
	
	

}

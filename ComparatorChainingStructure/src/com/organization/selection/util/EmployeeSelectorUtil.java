package com.organization.selection.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.company.Employee;
import com.organization.selection.criteria.Criteria;

public class EmployeeSelectorUtil {
	
	public static List<Employee> selectXPercentageEmployeesUnder(Employee employeeObj,
			ArrayList<Comparator<Employee>> selectionCriteriaList,
			int percentToSelect) {
		List<Employee> selectedEmployeeList = new ArrayList<Employee>();

		
		if(employeeObj.getReportingEmployeeList()==null||(employeeObj.getReportingEmployeeList()!=null && employeeObj.getReportingEmployeeList().size()==0)){
			//No Employees reporting to this one then return an empty list
			return new ArrayList<Employee>();
		}else{
			// there are employees reporting
			//In that case choose employees.
			Criteria c = buildCriteriaFromComparatorList(selectionCriteriaList);
			int numberOfReportingEmployees = employeeObj.getReportingEmployeeList().size();
			//TODO: need to ceil or floor based on current % of employees processed so far. 
			
			int numberOfEmployeesToSelect = (int)(((double)numberOfReportingEmployees)*((double)percentToSelect)/100.0);
			int numberOfEmployeesSelected = 0;
			if(!shouldApplyFloor())
			{
				numberOfEmployeesToSelect++;
			}
			
			List<Employee> list = employeeObj.getReportingEmployeeList();
			Collections.sort( list, c); //(nlogn * k) where k is the number of selection criterias to be applied. 
										//n is the size of the list of employees reporting to employeeObj
			
			for(Employee e : list){
				if(numberOfEmployeesSelected<numberOfEmployeesToSelect)
				{
					selectedEmployeeList.add(e);
					numberOfEmployeesSelected++;
				}
				
			}
			
		}
		
		for(Employee emp : employeeObj.getReportingEmployeeList())
		{
		selectedEmployeeList.addAll(selectXPercentageEmployeesUnder(emp, selectionCriteriaList, percentToSelect));
		}
	
		return selectedEmployeeList;

	}


	private static Criteria buildCriteriaFromComparatorList(ArrayList<Comparator<Employee>> selectionCriteriaComparatorList)
	{
		Criteria previousCriteria = null;
		Criteria newCriteria = null;
		for(int i = selectionCriteriaComparatorList.size()-1;i>=0 ; i--)
		{
			newCriteria = new Criteria();
			
			newCriteria.setPrimaryComparator(selectionCriteriaComparatorList.get(i));
			
			if(newCriteria.getSecondaryCriteria()==null)
				newCriteria.setSecondaryCriteria(previousCriteria);
			
			previousCriteria = newCriteria;
			
			
		}
		return newCriteria;
	
	}
	
	static int numberOfEmployeesProcessedSoFar=0;
	static int numberOfEmployeesSelectedSoFar=0;
	
	
	 static boolean shouldApplyFloor(){
		//TODO:Hardcoding for now
		return true;
	}
}

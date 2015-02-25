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
public class MainClass {

	public static void main(String[] args) {
		List<Employee> reportingEmployeeList = new ArrayList<Employee>();

		Employee E4 = new Employee();

		E4.setId(4);
		E4.setName("4");
		E4.setRating(1);
		E4.setReportingEmployeeList(null);
		E4.setSalary(40000);

		Employee E5 = new Employee();

		E5.setId(5);
		E5.setName("5");
		E5.setRating(4);
		E5.setReportingEmployeeList(null);
		E5.setSalary(40000);

		Employee E6 = new Employee();

		E6.setId(6);
		E6.setName("6");
		E6.setRating(5);
		E6.setReportingEmployeeList(null);
		E6.setSalary(40000);

		Employee E7 = new Employee();

		E7.setId(7);
		E7.setName("7");
		E7.setRating(3);
		E7.setReportingEmployeeList(null);
		E7.setSalary(20000);

		reportingEmployeeList = new ArrayList<Employee>();

		reportingEmployeeList.add(E4);
		reportingEmployeeList.add(E5);

		Employee E2 = new Employee();

		E2.setId(2);
		E2.setName("2");
		E2.setRating(1);
		E2.setReportingEmployeeList(reportingEmployeeList); // e4 and e5 under
															// e2
		E2.setSalary(40000);

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

		reportingEmployeeList = new ArrayList<Employee>();

		reportingEmployeeList.add(E3);
		reportingEmployeeList.add(E2);

		Employee E1 = new Employee();

		E1.setId(1);
		E1.setName("One");
		E1.setRating(3);
		E1.setReportingEmployeeList(reportingEmployeeList);
		E1.setSalary(50000);

		ArrayList<Comparator<Employee>> selectionCriteriaList = new ArrayList<Comparator<Employee>>();

		RatingComparator r = new RatingComparator();
		SalaryComparator s = new SalaryComparator();
		selectionCriteriaList.add(r);
		selectionCriteriaList.add(s);
		System.out.println("Employee IDs that are selected : ");
		for (Employee E : EmployeeSelectorUtil.selectXPercentageEmployeesUnder(
				E1, selectionCriteriaList, 100)) {
			System.out.println(E.getName());

		}
	}

}

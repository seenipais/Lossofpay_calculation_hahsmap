package interfacePkg;

import java.util.HashMap;
import pojoPkg.Employee;

public interface EmployeeMaintainance {

	HashMap<Integer,Employee> paisEmployee=new HashMap<Integer,Employee>();
	
	public void addEmployee();
	public void viewEmployee(int empID);
	public void viewEmployeeDesignation(int empID);
	

}


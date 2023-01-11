package mainPkg;

import java.util.Iterator; 
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import interfacePkg.EmployeeMaintainance;
import interfacePkg.PayRollCalculation;
import pojoPkg.Address;
import pojoPkg.Employee;


public class Pais_Inc implements PayRollCalculation,EmployeeMaintainance {

	// employee Stating ID
	private int employeeID=1001;
	
	//Employee details variables
	String employeeName,qualification;
	int age,designation;
	float experience;
	
	
	// address variables
	int doorNo;
	String street,city,state;
	int pinCode;
	
	boolean status=true;

	Scanner scanner=new Scanner(System.in);
	
	@Override
	public void addEmployee() {
		
		System.out.println("Enter Employee Name");
		employeeName=scanner.next();
		
		System.out.println("Enter Employee Age");
		age=scanner.nextInt();
		
		//get address
		System.out.println("Enter Permenant Address Details\n-----------------------------------------");
		System.out.println("Enter Door No ");
		doorNo=scanner.nextInt();
		
		System.out.println("Enter Street Name ");
		street=scanner.next();
		
		System.out.println("Enter city Name ");
		city=scanner.next();
		
		System.out.println("Enter state Name ");
		state=scanner.next();
		
		System.out.println("Enter PinCode ");
		pinCode=scanner.nextInt();
		//end of addess
		
		System.out.println("Enter Employee Experiences");
		experience=scanner.nextFloat();
		System.out.println("Enter Employee Qualification");
		qualification=scanner.next();   //Junior, Senior, Lead, Manager}
		System.out.println("Enter Employee Designation \n\n 1.JUNIOR \n 2.SENIOR \n 3. LEAD \n 4.MANAGER \n");
		designation=scanner.nextInt();
		paisEmployee.put(employeeID,new Employee(employeeName,qualification,new Address(doorNo,street,city,state, pinCode),experience,age,designation));
		//System.out.println(paisEmployee);

		employeeID++;
	}

	@Override
	public void viewEmployee(int empID) {
		
		Set<?> s=paisEmployee.entrySet();
		Iterator<?> i=s.iterator();
		
	if(empID==0)
	{
		while(i.hasNext())
		{
			Map.Entry emp=(Map.Entry)i.next();
			Object keysobj=emp.getKey();
			Employee employee=(Employee)emp.getValue();

				System.out.println("Employee ID - "+keysobj+""
						+ "\n Employee NAME - "+employee.getEmployeeName()+""
						+ "\n Employee Age - "+employee.getAge()+""
						+ "\n---------------------------------------"
						+ "\n Employee Address Details -"+employee.getAddress()+""
						+ "\n Employee Qualification - "+employee.getQualification()+""
						+ "\n Employee Designation - "+employee.getDesignationStr()+""
						+ "\n Employee Salary -"+employee.getSalary()+""
						+ "\n Employee Experience - "+employee.getExperience()+""
						+ "\n------------------------------------------------\n\n");
		}
	}
	else
	{
		if(paisEmployee.containsKey(empID))
		{
			Employee employee= paisEmployee.get(empID);
			System.out.println("\n Employee ID - "+empID+""
						+ "\n Employee NAME - "+employee.getEmployeeName()+""
						+ "\n Employee Age - "+employee.getAge()+""
						+ "\n---------------------------------------"
						+ "\n Employee Address Details -"+employee.getAddress()+""
						+ "\n Employee Qualification - "+employee.getQualification()+""
						+ "\n Employee Designation - "+employee.getDesignationStr()+""
						+ "\n Employee Salary -"+Math.abs( employee.getSalary())+""
						+ "\n Employee Experience - "+employee.getExperience()+""
						+ "\n------------------------------------------------\n\n");
		}
		else
		{
			System.out.println("NO SUCH EMPLOYEE ID REGISTERED---\n please Enter Valid employee ID");
		}
	}
}
	
	@Override
	public void updateSalary(int empId,double salary) {
		
		if(paisEmployee.containsKey(empId))
		{
			Employee employee=paisEmployee.get(empId);
			employee.setSalary(salary);
		}
		else
		{
			System.out.println("NO SUCH EMPLOYEE ID REGISTERED---"
					+ "\n please Enter Valid employee ID");
		}
	}

	
	@Override
	public void viewcalculatedsalary(int empID) {

		calculateLossOfPay();
		
		Set<?> s=paisEmployee.entrySet();
		Iterator<?> i=s.iterator();
	if(empID==0)
	{
		System.out.println("(--Monthly--)Salary For All Employees ");
		while(i.hasNext()) 
		{
			Map.Entry emp=(Map.Entry) i.next();
			Object keysobj=emp.getKey();
			Employee employee=(Employee)emp.getValue();
			
			 System.out.println("\n Employee ID - "+keysobj +""
			 		+ " \n Employee Name - " +employee.getEmployeeName()+""
			 		+ " \n This Month Salary - " +employee.getMonthlySalary()+""
			 		+ " \n Actual Month Salary - "+employee.getSalary());
		}
	}
	else
	{
		System.out.println("(--Monthly--)Salary For an Employee ");
		if(paisEmployee.containsKey(empID))
		{
			Employee employee=paisEmployee.get(empID);
			 System.out.println("\n Employee ID - "+empID +""
				 		+ " \n Employee Name - " +employee.getEmployeeName()+""
				 		+ " \n This Month Salary - " +employee.getMonthlySalary()+""
				 		+ " \n Actual Month Salary - "+employee.getSalary());
		}
		else
		{
			System.out.println("NO SUCH EMPLOYEE ID REGISTERED---"
					+ "\n please Enter Valid employee ID");
		}
	}
}
	
	private void calculateLossOfPay() {
		
		int leave;
		double employeeSalary;
		Set<?> s=paisEmployee.entrySet();
		Iterator<?> i=s.iterator();
		
		while(i.hasNext()) 
		{
			Map.Entry emp=(Map.Entry) i.next();
			Object keysobj=emp.getKey();
			Employee employee=(Employee)emp.getValue();
			leave=employee.getLeaveCount();
			if(leave<0)
			{
			leave=-leave;
			employeeSalary=employee.getSalary()/30;
			employeeSalary=employeeSalary*leave;
			employeeSalary=employee.getSalary()-employeeSalary;
			employee.setMonthlySalary(employeeSalary);
			}
			else
			{
				employee.setMonthlySalary(employee.getSalary());
			}
		}
	}
	
	@Override
	public void viewBalanceLeave(int empId) {
		
		Set<?> s=paisEmployee.entrySet();
		Iterator<?> i=s.iterator();
		
		if(empId==0)
		{
			System.out.println(" Balance Leave  Count For All Employee ");
			while(i.hasNext()) 
			{
				Map.Entry emp=(Map.Entry) i.next();
				Object keysobj=emp.getKey();
				Employee employee=(Employee)emp.getValue();
				
				 System.out.println("\n Employee ID - "+keysobj +""
				 		+ " \n Employee Name - " +employee.getEmployeeName()+""
				 		+ " \n Leave Count - " +employee.getLeaveCount()+"\n\n");
			}	
		}
		else
		{
			if(paisEmployee.containsKey(empId))
			{
				Employee employee=paisEmployee.get(empId);
				 System.out.println("Employee ID - "+empId +""
					 		+ " \n Employee Name - " +employee.getEmployeeName()+""
					 		+ " \n Leave Count - " +employee.getLeaveCount());
			}
			else
			{
				System.out.println("NO SUCH EMPLOYEE ID REGISTERED---"
						+ "\n please Enter Valid employee ID");
			}
		}	
	}
	
	@Override
	public void viewEmployeeDesignation(int empID) {
		
		Set<?> s=paisEmployee.entrySet();
		Iterator<?> i=s.iterator();
		
		if(empID==0)
		{	
			System.out.println("All Employee details with Designation ");
			while(i.hasNext()) 
			{
				Map.Entry emp=(Map.Entry) i.next();
				Object keysobj=emp.getKey();
				Employee employee=(Employee)emp.getValue();
		
				 System.out.println("\n Employee ID - "+keysobj +""
				 		+ " \n Employee Name - " +employee.getEmployeeName()+""
				 		+ " \n Employee Designation - " +employee.getDesignationStr()+"\n\n");
			}	
		}
		else
		{
			if(paisEmployee.containsKey(empID))
			{
				Employee employee=paisEmployee.get(empID);
				 System.out.println("Employee ID - "+empID +""
					 		+ " \n Employee Name - " +employee.getEmployeeName()+""
					 		+ " \n Employee Designation - " +employee.getDesignationStr());
			}
			else
			{
					System.out.println("NO SUCH EMPLOYEE ID REGISTERED---"
							+ "\n please Enter Valid employee ID");
			}
		}
	}	

	@Override
	public void updateLeave(int empId,int count) {
		if(paisEmployee.containsKey(empId))
		{
			Employee employee=paisEmployee.get(empId);
			count=employee.getLeaveCount()-count;
			employee.setLeaveCount(count);
			System.out.println(" \n leave Updated successfully \n");
		}
		else
		{
				System.out.println("NO SUCH EMPLOYEE ID REGISTERED---"
						+ "\n please Enter Valid employee ID");
		}
	}
}
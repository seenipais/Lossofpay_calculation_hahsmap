package mainPkg;

import java.util.Scanner;

public class MainApplication  {

	public static void main(String[] args) {
		
		Pais_Inc paisCorp=new Pais_Inc();
		int EID=1001;
		
		
		int choice,optionalEmpId=0,i=0,count=0;
		double salary=0.0;
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("\t\t\t\t Pais Inc \n \t\t\t  ~~~~~~~~~~~~~~~ \n");
		
		
		while(i==0)
		{
			try
			{
		System.out.println("\n 1. To Add Employee "
				+ "\n 2. To View All Employees (or) Single employee with all details "
				+ "\n 3. To View All Employees (or) Single Employee with Designation Only"
				+ "\n 4. To Update Leave For An Employee "
				+ "\n 5. To Add Salary For An Employee"
				+ "\n 6. To Display Salary For All Employee"
				+ "\n 7. To View Balance Leave For An Employee"
				+ "\n 0. To Exit The Application\n"
				+ "Enter The Choice \n");
		choice=scanner.nextInt();		
		
		switch(choice) {	
		
		case 1:
			// add employee
			paisCorp.addEmployee();
			System.out.println("WELCOME "+paisCorp.employeeName.toUpperCase()+" TO Pais Inc \n");
			System.out.println("\n YOUR Employee ID  is :-  " + EID);
			EID++;
			break;
			
		case 2:
			//view all employees or single employee with all details
			System.out.println("Pais Inc \n\n ALL EMPLOYEE  DATABASE "
					+ "\n--------------------------------\n");
			System.out.println("Enter Employee ID To view Particular (or) 0 For All Employee ");
			optionalEmpId=scanner.nextInt();
			paisCorp.viewEmployee(optionalEmpId);
			break;
			
		case 3:
			//view all employee or single employee with designation only
			System.out.println("Enter Employee ID To view Particular (or) 0 For All Employee ");
			optionalEmpId=scanner.nextInt();
			paisCorp.viewEmployeeDesignation(optionalEmpId);
			break;
			
		case 4:
			//leave update parameter as empID
			System.out.println("Enter Employee ID To Update Leave for Particular employee ");
			optionalEmpId=scanner.nextInt();
			System.out.println("Enter Leave Count For Employee ID - "+ optionalEmpId+" - ");
			count=scanner.nextInt();
			paisCorp.updateLeave(optionalEmpId,count);
			break;
			
		case 5:
			//add salary parameter as empID
			System.out.println("\n Update Salary for  Particular employee \n");
			System.out.println("Enter Employee ID - ");
			optionalEmpId=scanner.nextInt();
			System.out.println("Enter Salary - ");
			salary=scanner.nextDouble();
			paisCorp.updateSalary(optionalEmpId,salary);
			break;
			
		case 6:
			//calculate salary
			System.out.println("Enter Employee ID To view Salary Particular (or) 0 For All Employee ");
			optionalEmpId=scanner.nextInt();
			paisCorp.viewcalculatedsalary(optionalEmpId);
			break;
			
		case 7:
			//view leave balance parameter as empID
			System.out.println("Enter Employee ID To view  Balance Leave Count Particular (or) 0 For All Employee ");
			optionalEmpId=scanner.nextInt();
			paisCorp.viewBalanceLeave(optionalEmpId);
			break;
			
		case 0:
			// exit application
			System.out.println(" Once exit The data will be erased   "
					+ "\n  to confirm press 1");
			if(scanner.nextInt()==1)
			{
			System.out.println("EXITING APPLICATION ...!!! ");
			i=1;
				break;
			}
			else
			{
				continue;
			}
			
		default:
			System.out.println("Please Enter Proper/Valid Input : ");
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		}
		
		
		
	}

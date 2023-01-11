package interfacePkg;

public interface PayRollCalculation {

	
	public void updateSalary(int empId,double salary);
	public void updateLeave(int empId,int count);
	
	public void viewcalculatedsalary(int EmpId);
	public void viewBalanceLeave(int empId);
	
}

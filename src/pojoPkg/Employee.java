package pojoPkg;

public class Employee {

	String employeeName;
	String qualification;
	Address address;
	float experience;
	int age,leaveCount,var;
	double salary,MonthlySalary;
	String designationStr="NOT-SET";
	enum Designation{Junior, Senior, Lead, Manager}
	
	public Employee() {}
	

	public Employee(String employeeName, String qualification, Address address, float experience, int age ,int designation) {
		super();
		this.employeeName = employeeName;
		this.qualification = qualification;
		this.address = address;
		this.experience = experience;
		this.age = age;
		this.leaveCount = 15;
		

	    switch(designation) 
	    {
	      case 1:
	  		 designationStr = Designation.Junior.toString();
	 		this.salary=7000.00;
	        break;
	      case 2:
		  	 designationStr = Designation.Senior.toString();
				this.salary=15000.00;
	        break;
	      case 3:
	    	  designationStr = Designation.Lead.toString();
	  		this.salary=25000.00;
	      case 4:
	    	  designationStr = Designation.Manager.toString();
	  		this.salary=50000.00;
	        break;
	       default:
	    	   designationStr = "NOT-SET";
	   			this.salary=0.0;
	    }
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getQualification() {
		return qualification;
	}


	public String getDesignationStr() {
		return designationStr;
	}


	public void setDesignationStr(String designationStr) {
		this.designationStr = designationStr;
	}


	public void setExperience(float experience) {
		this.experience = experience;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public float getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getLeaveCount() {
		return leaveCount;
	}


	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}




	public double getMonthlySalary() {
		return MonthlySalary;
	}


	public void setMonthlySalary(double monthlySalary) {
		MonthlySalary = monthlySalary;
	}


	@Override
	public String toString() {
				return "Employee Details"
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ "\n employeeName - " + employeeName + "\n"
				+ "\n age - " + age + "\n"
				+ "\n address - " + address
				+ "\n qualification- " + qualification + "\n"
				+ "\n Designation - " +designationStr
				+ "\n experience - " + experience + "\n"
				+ "\n salary - " + salary +"\n"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	}
	
}
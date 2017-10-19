import java.io.*;

public class EmployeeTest {
	public static void main(String args[]){
		
		Employee empOne = new Employee("James Smith");
		Employee empTwo = new Employee("Marry Anne");
		
		empOne.empAge(26);
		empOne.empDesignation("Senior Software Engineer");
		empOne.empSalary(1000);
		empOne.printEmployee();
		
		System.out.println(" ");
		
		empTwo.empAge(21);
		empTwo.empDesignation("Software Engineer");
		empTwo.empSalary(500);
		empTwo.printEmployee();
	}
}

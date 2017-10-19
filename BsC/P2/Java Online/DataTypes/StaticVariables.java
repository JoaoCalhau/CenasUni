import java.io.*;

public class StaticVariables {
	
	private static double salary;
	
	public static final String DEPARTMENT = "Development";
	//DEPARTMENT é uma constante por causa do 'final'
	
	public static void main(String args[]){
		salary = 1000;
		System.out.println(DEPARTMENT + " average salary: "+ salary);
	}
	
}

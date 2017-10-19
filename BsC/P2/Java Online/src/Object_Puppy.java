
public class Object_Puppy {
	
	int puppyAge;
	
	public Object_Puppy(String name){
		System.out.println("Passed Name is: "+ name);
	}
	
	public void setAge(int age){
		puppyAge = age;
	}
	
	public int getAge(){
		System.out.println("Puppy's age is: "+ puppyAge);
		return puppyAge;
	}
	
	public static void main(String[] args){
		Object_Puppy myPuppy = new Object_Puppy("Tommy");
		//para criar uma nova variavel do tipo contrutor definido, neste caso 'Object_Puppy' temos de usar o metodo 'new'
		
		myPuppy.setAge(2);;
		
		myPuppy.getAge();
		
		System.out.println("Variable Value: "+ myPuppy.puppyAge);
	}
}

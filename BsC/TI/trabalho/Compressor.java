import java.io.*;
import java.util.*;

public class Compressor {
	String input="";
	String output="";
	
	int totalA= 0;
	int totalC= 0;
	int totalT= 0;
	int totalG= 0;
	
	
	public Compressor() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("codigo.txt"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        
	        
	        this.input = sb.toString();
	    } finally {
	        br.close();
	    }
	    
	    System.out.println(input.length() + "tamanho total\n");
	    
	}
	
	void Calcular2(){
		for(int i = 0; i<input.length(); i++){
			if (input.charAt(i)== 'A'){
				totalA++;
				
			}	
				
				
			if (input.charAt(i)== 'T'){
				totalT++;
				
			}
			
			
			if (input.charAt(i)== 'G'){
				totalG++;
				
			}
			
			if (input.charAt(i)== 'C'){
				totalC++;
				
			}
			
		
		}
	}
	
	public void Calcular3(){
		System.out.println(this.totalA + "total A\n");
		System.out.println(this.totalC + "total C\n");
		System.out.println(this.totalT + "total T\n");
		System.out.println(this.totalG + "total G\n");
		
	}
	
	
	
	
	
	

public static void main(String [ ] args) throws IOException{
	Compressor teste = new Compressor();
	teste.Calcular2();
	teste.Calcular3();
}
}

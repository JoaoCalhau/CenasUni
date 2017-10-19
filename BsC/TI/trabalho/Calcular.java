import java.io.*;
import java.util.*;

public class Calcular {
	String input="";
	String output="";
	
	
	int total0= 0;
	int certo0= 0;
	int err01 = 0;
	int err02 = 0;
	
	int total1= 0;
	int certo1= 0;
	int err10 = 0;
	int err12 = 0;
	
	int total2= 0;
	int certo2= 0;
	int err20 = 0;
	int err21 = 0;
	
	
	public Calcular() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
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
	    
	    BufferedReader br2 = new BufferedReader(new FileReader("output.txt"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br2.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br2.readLine();
	        }
	        this.output = sb.toString();
	    } finally {
	        br2.close();
	    }
	}
	
	void Calcular2(){
		for(int i = 0; i<input.length(); i++){
			if (input.charAt(i)== '0'){
				total0++;
				if (output.charAt(i)== '1'){
					err01++;
				}
				if (output.charAt(i)== '2'){
					err02++;
				}
				if (output.charAt(i)== '0'){
					certo0++;
				}
			}	
				
				
			if (input.charAt(i)== '1'){
				total1++;
				if (output.charAt(i)== '0'){
					err10++;
				}
				if (output.charAt(i)== '2'){
					err12++;
				}
				if (output.charAt(i)== '1'){
					certo1++;
				}
			}
			
			
			if (input.charAt(i)== '2'){
				total2++;
				if (output.charAt(i)== '0'){
					err20++;
				}
				if (output.charAt(i)== '1'){
					err21++;
				}
				if (output.charAt(i)== '2'){
					certo2++;
				}
			}
			
		
		}
	}
	
	public void Calcular3(){
		System.out.println(this.total0);
		System.out.println(this.total1);
		System.out.println(this.total2);
		
		
		float ZeroZero = (float)certo0/(float)total0;
		float ZeroUm = (float)err01/(float)total0;
		float ZeroDois = (float)err02/(float)total0;
		
		float UmUm = (float)certo1/(float)total1;
		float UmZero = (float)err10/(float)total1;
		float UmDois = (float)err12/(float)total1;
		
		float DoisDois = (float)certo2/(float)total2;
		float DoisZero = (float)err20/(float)total2;
		float DoisUm = (float)err21/(float)total2;
		
		System.out.println(
				"\n"+
		"total 0: "+total0+"\n0-0: "+certo0 + "\n% 0-0: "+ZeroZero + "\n"+
		"\n0-1: "+err01 +"\n% 0-1: "+ ZeroUm + "\n"+
		"\n0-2: "+err02 +"\n% 0-2: "+ ZeroDois +"\n" +"\n" 
		+ "\n"+ "\n"+
		"total 1: "+total1+"\n1-1: "+certo1 + "\n% 1-1: "+UmUm + "\n"+
		"\n1-0: "+err10 +"\n% 1-0: "+ UmZero + "\n"+
		"\n1-2: "+err12 +"\n% 1-2: "+ UmDois +"\n" +"\n"
		+ "\n"+ "\n"+
		"total 2: "+total2+"\n2-2: "+certo2 + "\n% 2-2: "+DoisDois + "\n"+
		"\n2-0: "+err20 +"\n% 2-0: "+ DoisZero + "\n"+
		"\n2-1: "+err20 +"\n% 2-1: "+ DoisUm +"\n" +"\n"
			
				
				
				);
	}
	
	
	
	
	
	

public static void main(String [ ] args) throws IOException{
	Calcular teste = new Calcular();
	teste.Calcular2();
	teste.Calcular3();
}
}

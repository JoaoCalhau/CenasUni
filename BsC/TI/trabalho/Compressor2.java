import java.io.*;
import java.util.*;

public class Compressor2 {
	String input="";
	
	int total2= 0; 
	
	
	int totalAA= 0;
	int totalAC= 0;
	int totalAT= 0;
	int totalAG= 0;
	
	int totalCC= 0;
	int totalCA= 0;
	int totalCG= 0;
	int totalCT= 0;
	
	int totalTT= 0;
	int totalTA= 0;
	int totalTG= 0;
	int totalTC= 0;
	
	int totalGG= 0;
	int totalGA= 0;
	int totalGT= 0;
	int totalGC= 0;
	
	int total=0;
	
	
	public Compressor2() throws IOException {
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
		int aaa=(input.length()*2);
		for(int i = 0; i<input.length(); i=i+2){
			if (input.charAt(i)== 'A'){
				if (input.charAt(i+1)== 'A'){
					totalAA++;
				}
				if (input.charAt(i+1)== 'C'){
					totalAC++;
				}
				if (input.charAt(i+1)== 'T'){
					totalAT++;
				}
				if (input.charAt(i+1)== 'G'){
					totalAG++;
				}
				
			}	
			
			
			if (input.charAt(i)== 'C'){
				if (input.charAt(i+1)== 'C'){
					totalCC++;
				}
				if (input.charAt(i+1)== 'A'){
					totalCA++;
				}
				if (input.charAt(i+1)== 'G'){
					totalCG++;
				}
				if (input.charAt(i+1)== 'T'){
					totalCT++;
				}
				
			}
			
			
				
			if (input.charAt(i)== 'T'){
				if (input.charAt(i+1)== 'T'){
					totalTT++;
				}
				if (input.charAt(i+1)== 'A'){
					totalTA++;
				}
				if (input.charAt(i+1)== 'G'){
					totalTG++;
				}
				if (input.charAt(i+1)== 'C'){
					totalTC++;
				}
				
			}
			
			
			if (input.charAt(i)== 'G'){
				if (input.charAt(i+1)== 'G'){
					totalGG++;
				}
				if (input.charAt(i+1)== 'A'){
					totalGA++;
				}
				if (input.charAt(i+1)== 'T'){
					totalGT++;
				}
				if (input.charAt(i+1)== 'C'){
					totalGC++;
				}
				
			}
			
			
			
		
		}
		
		total+=totalAA;
		total+=totalAC;
		total+=totalAT;
		total+=totalAG;
		
		total+=totalTT;
		total+=totalTC;
		total+=totalTA;
		total+=totalTG;
		
		total+=totalCC;
		total+=totalCA;
		total+=totalCG;
		total+=totalCT;
		
		total+=totalGG;
		total+=totalGA;
		total+=totalGC;
		total+=totalGT;





		this.Calcular3();





	}
	
	public void Calcular3(){
		System.out.println(	"total AA: " + this.totalAA + "/   "+ (float)this.totalAA/(float)(input.length()/2)+"%\n"+
							"total AC: " + this.totalAC + "/   "+ (float)this.totalAC/(float)(input.length()/2)+"%\n"+
							"total AT: " + this.totalAT + "/   "+ (float)this.totalAT/(float)(input.length()/2)+"%\n"+
							"total AG: " + this.totalAG + "/   "+ (float)this.totalAG/(float)(input.length()/2)+"%\n\n"+
							
							"total CC: "+ this.totalCC + "/   "+ (float)this.totalCC/(float)(input.length()/2)+"%\n"+
							"total CA: "+ this.totalCA + "/   "+ (float)this.totalCA/(float)(input.length()/2)+"%\n"+
							"total CG: "+ this.totalCG + "/   "+ (float)this.totalCG/(float)(input.length()/2)+"%\n"+
							"total CT: "+ this.totalCT + "/   "+ (float)this.totalCT/(float)(input.length()/2)+"%\n\n"+
							
							"total TT: "+ this.totalTT + "/   "+ (float)this.totalTT/(float)(input.length()/2)+"%\n"+
							"total TA: "+ this.totalTA + "/   "+ (float)this.totalTA/(float)(input.length()/2)+"%\n"+
							"total TG: "+ this.totalTG + "/   "+ (float)this.totalTG/(float)(input.length()/2)+"%\n"+
							"total TC: "+ this.totalTC + "/   "+ (float)this.totalTC/(float)(input.length()/2)+"%\n\n"+
							
							"total GG: "+ this.totalGG + "/   "+ (float)this.totalGG/(float)(input.length()/2)+"%\n"+
							"total GA: "+ this.totalGA + "/   "+ (float)this.totalGA/(float)(input.length()/2)+"%\n"+
							"total GT: "+ this.totalGT + "/   "+ (float)this.totalGT/(float)(input.length()/2)+ "%\n"+
							"total GC: "+ this.totalGC + "/   "+ (float)this.totalGC/(float)(input.length()/2)+"%\n" +
							"total do ficheiro/2: "+ input.length()/2 +"\n"+
							"total: "+ total
							);
		
		
		
		
		
		
	}
	
	
	void Calcular4(){
		for(int i = 0; i<input.length(); i++){
			if (input.charAt(i)== 'A'){
				if (input.charAt(i+1)== 'A'){
					totalAA++;
				}
				if (input.charAt(i+1)== 'C'){
					totalAC++;
				}
				if (input.charAt(i+1)== 'T'){
					totalAT++;
				}
				if (input.charAt(i+1)== 'G'){
					totalAG++;
				}
				
			}	
			
			
			if (input.charAt(i)== 'C'){
				if (input.charAt(i+1)== 'C'){
					totalCC++;
				}
				if (input.charAt(i+1)== 'A'){
					totalCA++;
				}
				if (input.charAt(i+1)== 'G'){
					totalCG++;
				}
				if (input.charAt(i+1)== 'T'){
					totalCT++;
				}
				
			}
			
			
				
			if (input.charAt(i)== 'T'){
				if (input.charAt(i+1)== 'T'){
					totalTT++;
				}
				if (input.charAt(i+1)== 'A'){
					totalTA++;
				}
				if (input.charAt(i+1)== 'G'){
					totalTG++;
				}
				if (input.charAt(i+1)== 'C'){
					totalTC++;
				}
				
			}
			
			
			if (input.charAt(i)== 'G'){
				if (input.charAt(i+1)== 'G'){
					totalGG++;
				}
				if (input.charAt(i+1)== 'A'){
					totalGA++;
				}
				if (input.charAt(i+1)== 'T'){
					totalGT++;
				}
				if (input.charAt(i+1)== 'C'){
					totalGC++;
				}
				
			}
			
			
			
		
		}
		
		


		total2+=totalAA;
		total2+=totalAC;
		total2+=totalAT;
		total2+=totalAG;
		
		total2+=totalTT;
		total2+=totalTC;
		total2+=totalTA;
		total2+=totalTG;
		
		total2+=totalCC;
		total2+=totalCA;
		total2+=totalCG;
		total2+=totalCT;
		
		total2+=totalGG;
		total2+=totalGA;
		total2+=totalGC;
		total2+=totalGT;

		
		









	
		System.out.println(	"total AA: " + this.totalAA + "/   "+ (float)this.totalAA/(float)(input.length())+"%\n"+
							"total AC: " + this.totalAC + "/   "+ (float)this.totalAC/(float)(input.length())+"%\n"+
							"total AT: " + this.totalAT + "/   "+ (float)this.totalAT/(float)(input.length())+"%\n"+
							"total AG: " + this.totalAG + "/   "+ (float)this.totalAG/(float)(input.length())+"%\n\n"+
							
							"total CC: "+ this.totalCC + "/   "+ (float)this.totalCC/(float)(input.length())+"%\n"+
							"total CA: "+ this.totalCA + "/   "+ (float)this.totalCA/(float)(input.length())+"%\n"+
							"total CG: "+ this.totalCG + "/   "+ (float)this.totalCG/(float)(input.length())+"%\n"+
							"total CT: "+ this.totalCT + "/   "+ (float)this.totalCT/(float)(input.length())+"%\n\n"+
							
							"total TT: "+ this.totalTT + "/   "+ (float)this.totalTT/(float)(input.length())+"%\n"+
							"total TA: "+ this.totalTA + "/   "+ (float)this.totalTA/(float)(input.length())+"%\n"+
							"total TG: "+ this.totalTG + "/   "+ (float)this.totalTG/(float)(input.length())+"%\n"+
							"total TC: "+ this.totalTC + "/   "+ (float)this.totalTC/(float)(input.length())+"%\n\n"+
							
							"total GG: "+ this.totalGG + "/   "+ (float)this.totalGG/(float)(input.length())+"%\n"+
							"total GA: "+ this.totalGA + "/   "+ (float)this.totalGA/(float)(input.length())+"%\n"+
							"total GT: "+ this.totalGT + "/   "+ (float)this.totalGT/(float)(input.length())+ "%\n"+
							"total GC: "+ this.totalGC + "/   "+ (float)this.totalGC/(float)(input.length())+"%\n" +
							"total do ficheiro: "+ input.length() +"\n"+
							"total: "+ total2
							);
		
		
		
	}
	
	
	
	
	
	

public static void main(String [ ] args) throws IOException{
	Compressor2 teste = new Compressor2();
	teste.Calcular2();
	//teste.Calcular4();
}
}
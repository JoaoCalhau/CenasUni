import java.io.*;
import java.lang.Math;

public class Compressor2 {
	static String input="";

	static int total2= 0; 


	static int totalAA= 0;
	static int totalAC= 0;
	static int totalAT= 0;
	static int totalAG= 0;

	static int totalCC= 0;
	static int totalCA= 0;
	static int totalCG= 0;
	static int totalCT= 0;

	static int totalTT= 0;
	static int totalTA= 0;
	static int totalTG= 0;
	static int totalTC= 0;

	static int totalGG= 0;
	static int totalGA= 0;
	static int totalGT= 0;
	static int totalGC= 0;

	static int total=0;


	public static void read() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("codigo.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}


			input = sb.toString();
		} finally {
			br.close();
		}

		System.out.println(input.length() + " tamanho total\n");

	}

	static void Calcular2(){
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





		Calcular3();





	}

	public static void Calcular3(){
		System.out.println(	"total AA: " +  totalAA + "/   "+ (float) totalAA/(float)(input.length()/2)+"%\n"+
				"total AC: " +  totalAC + "/   "+ (float) totalAC/(float)(input.length()/2)+"%\n"+
				"total AT: " +  totalAT + "/   "+ (float) totalAT/(float)(input.length()/2)+"%\n"+
				"total AG: " +  totalAG + "/   "+ (float) totalAG/(float)(input.length()/2)+"%\n\n"+

							"total CC: "+  totalCC + "/   "+ (float) totalCC/(float)(input.length()/2)+"%\n"+
							"total CA: "+  totalCA + "/   "+ (float) totalCA/(float)(input.length()/2)+"%\n"+
							"total CG: "+  totalCG + "/   "+ (float) totalCG/(float)(input.length()/2)+"%\n"+
							"total CT: "+  totalCT + "/   "+ (float) totalCT/(float)(input.length()/2)+"%\n\n"+

							"total TT: "+  totalTT + "/   "+ (float) totalTT/(float)(input.length()/2)+"%\n"+
							"total TA: "+  totalTA + "/   "+ (float) totalTA/(float)(input.length()/2)+"%\n"+
							"total TG: "+  totalTG + "/   "+ (float) totalTG/(float)(input.length()/2)+"%\n"+
							"total TC: "+  totalTC + "/   "+ (float) totalTC/(float)(input.length()/2)+"%\n\n"+

							"total GG: "+  totalGG + "/   "+ (float) totalGG/(float)(input.length()/2)+"%\n"+
							"total GA: "+  totalGA + "/   "+ (float) totalGA/(float)(input.length()/2)+"%\n"+
							"total GT: "+  totalGT + "/   "+ (float) totalGT/(float)(input.length()/2)+ "%\n"+
							"total GC: "+  totalGC + "/   "+ (float) totalGC/(float)(input.length()/2)+"%\n" +
							"total do ficheiro/2: "+ input.length()/2 +"\n"+
							"total: "+ total
				);






	}


	static void Calcular4(){
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













		System.out.println(	"total AA: " +  totalAA + "/   "+ (float) totalAA/(float)(input.length())+"%\n"+
				"total AC: " +  totalAC + "/   "+ (float) totalAC/(float)(input.length())+"%\n"+
				"total AT: " +  totalAT + "/   "+ (float) totalAT/(float)(input.length())+"%\n"+
				"total AG: " +  totalAG + "/   "+ (float) totalAG/(float)(input.length())+"%\n\n"+

							"total CC: "+  totalCC + "/   "+ (float) totalCC/(float)(input.length())+"%\n"+
							"total CA: "+  totalCA + "/   "+ (float) totalCA/(float)(input.length())+"%\n"+
							"total CG: "+  totalCG + "/   "+ (float) totalCG/(float)(input.length())+"%\n"+
							"total CT: "+  totalCT + "/   "+ (float) totalCT/(float)(input.length())+"%\n\n"+

							"total TT: "+  totalTT + "/   "+ (float) totalTT/(float)(input.length())+"%\n"+
							"total TA: "+  totalTA + "/   "+ (float) totalTA/(float)(input.length())+"%\n"+
							"total TG: "+  totalTG + "/   "+ (float) totalTG/(float)(input.length())+"%\n"+
							"total TC: "+  totalTC + "/   "+ (float) totalTC/(float)(input.length())+"%\n\n"+

							"total GG: "+  totalGG + "/   "+ (float) totalGG/(float)(input.length())+"%\n"+
							"total GA: "+  totalGA + "/   "+ (float) totalGA/(float)(input.length())+"%\n"+
							"total GT: "+  totalGT + "/   "+ (float) totalGT/(float)(input.length())+ "%\n"+
							"total GC: "+  totalGC + "/   "+ (float) totalGC/(float)(input.length())+"%\n" +
							"total do ficheiro: "+ input.length() +"\n"+
							"total: "+ total2
				);



	}







	public static void main(String [ ] args) throws IOException{
		read();
		Calcular2();
		//teste.Calcular4();
		total2 = total/2;
		
		double pAA = (float)totalAA/total2;
		double pAC = (float)totalAC/total2;
		double pAG = (float)totalAG/total2;
		double pAT = (float)totalAT/total2;
		
		double pCA = (float)totalCA/total2;
		double pCC = (float)totalCC/total2;
		double pCG = (float)totalCG/total2;
		double pCT = (float)totalCT/total2;
		
		double pGA = (float)totalGA/total2;
		double pGC = (float)totalGC/total2;
		double pGG = (float)totalGG/total2;
		double pGT = (float)totalGT/total2;
		
		double pTA = (float)totalTA/total2;
		double pTC = (float)totalTC/total2;
		double pTG = (float)totalTG/total2;
		double pTT = (float)totalTT/total2;

		
		double entropiaA = (pAA * (Math.log(1/pAA)/Math.log(2))) + (pAC * (Math.log(1/pAC)/Math.log(2))) + (pAG * (Math.log(1/pAG)/Math.log(2))) + (pAT * (Math.log(1/pAT)/Math.log(2)));
		double entropiaC = (pCA * (Math.log(1/pCA)/Math.log(2))) + (pCC * (Math.log(1/pCC)/Math.log(2))) + (pCG * (Math.log(1/pCG)/Math.log(2))) + (pCT * (Math.log(1/pCT)/Math.log(2)));
		double entropiaG = (pGA * (Math.log(1/pGA)/Math.log(2))) + (pGC * (Math.log(1/pGC)/Math.log(2))) + (pGG * (Math.log(1/pGG)/Math.log(2))) + (pGT * (Math.log(1/pGT)/Math.log(2)));
		double entropiaT = (pTA * (Math.log(1/pTA)/Math.log(2))) + (pTC * (Math.log(1/pTC)/Math.log(2))) + (pTG * (Math.log(1/pTG)/Math.log(2))) + (pTT * (Math.log(1/pTT)/Math.log(2)));

		System.out.println("Entropia A : " + entropiaA);
		System.out.println("Entropia C : " + entropiaC);
		System.out.println("Entropia G : " + entropiaG);
		System.out.println("Entropia T : " + entropiaT);
		
		System.out.println(entropiaA + entropiaC + entropiaG + entropiaT);
	}
}

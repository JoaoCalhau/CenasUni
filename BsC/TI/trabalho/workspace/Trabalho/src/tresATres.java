import java.io.*;
import java.util.Scanner;

public class tresATres {
	
	static int total = 0;
	static int total3 = 0;

	//total A
	static int totalAAA = 0;
	static int totalAAC = 0;
	static int totalAAG = 0;
	static int totalAAT = 0;

	static int totalACA = 0;
	static int totalACC = 0;
	static int totalACG = 0;
	static int totalACT = 0;

	static int totalAGA = 0;
	static int totalAGC = 0;
	static int totalAGG = 0;
	static int totalAGT = 0;

	static int totalATA = 0;
	static int totalATC = 0;
	static int totalATG = 0;
	static int totalATT = 0;

	//totalC
	static int totalCAA = 0;
	static int totalCAC = 0;
	static int totalCAG = 0;
	static int totalCAT = 0;

	static int totalCCA = 0;
	static int totalCCC = 0;
	static int totalCCG = 0;
	static int totalCCT = 0;

	static int totalCGA = 0;
	static int totalCGC = 0;
	static int totalCGG = 0;
	static int totalCGT = 0;

	static int totalCTA = 0;
	static int totalCTC = 0;
	static int totalCTG = 0;
	static int totalCTT = 0;


	//total G
	static int totalGAA = 0;
	static int totalGAC = 0;
	static int totalGAG = 0;
	static int totalGAT = 0;

	static int totalGCA = 0;
	static int totalGCC = 0;
	static int totalGCG = 0;
	static int totalGCT = 0;

	static int totalGGA = 0;
	static int totalGGC = 0;
	static int totalGGG = 0;
	static int totalGGT = 0;

	static int totalGTA = 0;
	static int totalGTC = 0;
	static int totalGTG = 0;
	static int totalGTT = 0;


	//total T
	static int totalTAA = 0;
	static int totalTAC = 0;
	static int totalTAG = 0;
	static int totalTAT = 0;

	static int totalTCA = 0;
	static int totalTCC = 0;
	static int totalTCG = 0;
	static int totalTCT = 0;

	static int totalTGA = 0;
	static int totalTGC = 0;
	static int totalTGG = 0;
	static int totalTGT = 0;

	static int totalTTA = 0;
	static int totalTTC = 0;
	static int totalTTG = 0;
	static int totalTTT = 0;


	public static String read() {

		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		sc.close();

		try(BufferedReader br = new BufferedReader(new FileReader(in + ".txt"))) {

			String s = br.readLine();

			return s;

		} catch(IOException e) {
			System.out.println("Inexistent file...");
		}
		return null;
	}


	public static void calc(String s) {
		
		for(int i = 0; i < s.length()-1; i+=3) {
			if(s.charAt(i) == 'A') {
				if(s.charAt(i+1) == 'A') {
					if(s.charAt(i+2) == 'A')
						totalAAA++;
					else if(s.charAt(i+2) == 'C')
						totalAAC++;
					else if(s.charAt(i+2) == 'G')
						totalAAG++;
					else
						totalAAT++;
				} else if(s.charAt(i+1) == 'C') {
					if(s.charAt(i+2) == 'A')
						totalACA++;
					else if(s.charAt(i+2) == 'C')
						totalACC++;
					else if(s.charAt(i+2) == 'G')
						totalACG++;
					else
						totalACT++;
				} else if(s.charAt(i+1) == 'G') {
					if(s.charAt(i+2) == 'A')
						totalAGA++;
					else if(s.charAt(i+2) == 'C')
						totalAGC++;
					else if(s.charAt(i+2) == 'G')
						totalAGG++;
					else
						totalAGT++;
				} else {
					if(s.charAt(i+2) == 'A')
						totalATA++;
					else if(s.charAt(i+2) == 'C')
						totalATC++;
					else if(s.charAt(i+2) == 'G')
						totalATG++;
					else
						totalATT++;
				}
			} else if(s.charAt(i) == 'C') {
				if(s.charAt(i+1) == 'A') {
					if(s.charAt(i+2) == 'A')
						totalCAA++;
					else if(s.charAt(i+2) == 'C')
						totalCAC++;
					else if(s.charAt(i+2) == 'G')
						totalCAG++;
					else
						totalCAT++;
				} else if(s.charAt(i+1) == 'C') {
					if(s.charAt(i+2) == 'A')
						totalCCA++;
					else if(s.charAt(i+2) == 'C')
						totalCCC++;
					else if(s.charAt(i+2) == 'G')
						totalCCG++;
					else
						totalCCT++;
				} else if(s.charAt(i+1) == 'G') {
					if(s.charAt(i+2) == 'A')
						totalCGA++;
					else if(s.charAt(i+2) == 'C')
						totalCGC++;
					else if(s.charAt(i+2) == 'G')
						totalCGG++;
					else
						totalCGT++;
				} else {
					if(s.charAt(i+2) == 'A')
						totalCTA++;
					else if(s.charAt(i+2) == 'C')
						totalCTC++;
					else if(s.charAt(i+2) == 'G')
						totalCTG++;
					else
						totalCTT++;
				}
			} else if(s.charAt(i) == 'G') {
				if(s.charAt(i+1) == 'A') {
					if(s.charAt(i+2) == 'A')
						totalGAA++;
					else if(s.charAt(i+2) == 'C')
						totalGAC++;
					else if(s.charAt(i+2) == 'G')
						totalGAG++;
					else
						totalGAT++;
				} else if(s.charAt(i+1) == 'C') {
					if(s.charAt(i+2) == 'A')
						totalGCA++;
					else if(s.charAt(i+2) == 'C')
						totalGCC++;
					else if(s.charAt(i+2) == 'G')
						totalGCG++;
					else
						totalGCT++;
				} else if(s.charAt(i+1) == 'G') {
					if(s.charAt(i+2) == 'A')
						totalGGA++;
					else if(s.charAt(i+2) == 'C')
						totalGGC++;
					else if(s.charAt(i+2) == 'G')
						totalGGG++;
					else
						totalGGT++;
				} else {
					if(s.charAt(i+2) == 'A')
						totalGTA++;
					else if(s.charAt(i+2) == 'C')
						totalGTC++;
					else if(s.charAt(i+2) == 'G')
						totalGTG++;
					else
						totalGTT++;
				}
			} else {
				if(s.charAt(i+1) == 'A') {
					if(s.charAt(i+2) == 'A')
						totalTAA++;
					else if(s.charAt(i+2) == 'C')
						totalTAC++;
					else if(s.charAt(i+2) == 'G')
						totalTAG++;
					else
						totalTAT++;
				} else if(s.charAt(i+1) == 'C') {
					if(s.charAt(i+2) == 'A')
						totalTCA++;
					else if(s.charAt(i+2) == 'C')
						totalTCC++;
					else if(s.charAt(i+2) == 'G')
						totalTCG++;
					else
						totalTCT++;
				} else if(s.charAt(i+1) == 'G') {
					if(s.charAt(i+2) == 'A')
						totalTGA++;
					else if(s.charAt(i+2) == 'C')
						totalTGC++;
					else if(s.charAt(i+2) == 'G')
						totalTGG++;
					else
						totalTGT++;
				} else {
					if(s.charAt(i+2) == 'A')
						totalTTA++;
					else if(s.charAt(i+2) == 'C')
						totalTTC++;
					else if(s.charAt(i+2) == 'G')
						totalTTG++;
					else
						totalTTT++;
				}
			}
			total3++;
		}
	}
	
	public static void main(String[] args) {
		
		calc(read());
		
		total = total3*3;
		
		System.out.println("Totais :");
		System.out.println("total de letras: " + total + "\n");
		System.out.println("total por bloco: " + total3 + "\n");
		
		//prints A's
		System.out.println("total AAA: " + totalAAA + " vezes, ou seja em: " + (float)totalAAA/total3 * 100);
		System.out.println("total AAC: " + totalAAC + " vezes, ou seja em: " + (float)totalAAC/total3 * 100);
		System.out.println("total AAG: " + totalAAG + " vezes, ou seja em: " + (float)totalAAG/total3 * 100);
		System.out.println("total AAT: " + totalAAT + " vezes, ou seja em: " + (float)totalAAT/total3 * 100 + "\n");
		
		System.out.println("total ACA: " + totalACA + " vezes, ou seja em: " + (float)totalACA/total3 * 100);
		System.out.println("total ACC: " + totalACC + " vezes, ou seja em: " + (float)totalACC/total3 * 100);
		System.out.println("total ACG: " + totalACG + " vezes, ou seja em: " + (float)totalACG/total3 * 100);
		System.out.println("total ACT: " + totalACT + " vezes, ou seja em: " + (float)totalACT/total3 * 100 + "\n");
	 	
		System.out.println("total AGA: " + totalAGA + " vezes, ou seja em: " + (float)totalAGA/total3 * 100);
		System.out.println("total AGC: " + totalAGC + " vezes, ou seja em: " + (float)totalAGC/total3 * 100);
		System.out.println("total AGG: " + totalAGG + " vezes, ou seja em: " + (float)totalAGG/total3 * 100);
		System.out.println("total AGT: " + totalAGT + " vezes, ou seja em: " + (float)totalAGT/total3 * 100 + "\n");
		
		System.out.println("total ATA: " + totalATA + " vezes, ou seja em: " + (float)totalATA/total3 * 100);
		System.out.println("total ATC: " + totalATC + " vezes, ou seja em: " + (float)totalATC/total3 * 100);
		System.out.println("total ATG: " + totalATG + " vezes, ou seja em: " + (float)totalATG/total3 * 100);
		System.out.println("total ATT: " + totalATT + " vezes, ou seja em: " + (float)totalATT/total3 * 100 + "\n");
		
		//Prints C's
		System.out.println("total CAA: " + totalCAA + " vezes, ou seja em: " + (float)totalCAA/total3 * 100);
		System.out.println("total CAC: " + totalCAC + " vezes, ou seja em: " + (float)totalCAC/total3 * 100);
		System.out.println("total CAG: " + totalCAG + " vezes, ou seja em: " + (float)totalCAG/total3 * 100);
		System.out.println("total CAT: " + totalCAT + " vezes, ou seja em: " + (float)totalCAT/total3 * 100 + "\n");
		
		System.out.println("total CCA: " + totalCCA + " vezes, ou seja em: " + (float)totalCCA/total3 * 100);
		System.out.println("total CCC: " + totalCCC + " vezes, ou seja em: " + (float)totalCCC/total3 * 100);
		System.out.println("total CCG: " + totalCCG + " vezes, ou seja em: " + (float)totalCCG/total3 * 100);
		System.out.println("total CCT: " + totalCCT + " vezes, ou seja em: " + (float)totalCCT/total3 * 100 + "\n");
		
		System.out.println("total CGA: " + totalCGA + " vezes, ou seja em: " + (float)totalCGA/total3 * 100);
		System.out.println("total CGC: " + totalCGC + " vezes, ou seja em: " + (float)totalCGC/total3 * 100);
		System.out.println("total CGG: " + totalCGG + " vezes, ou seja em: " + (float)totalCGG/total3 * 100);
		System.out.println("total CGT: " + totalCGT + " vezes, ou seja em: " + (float)totalCGT/total3 * 100 + "\n");
		
		System.out.println("total CTA: " + totalCTA + " vezes, ou seja em: " + (float)totalCTA/total3 * 100);
		System.out.println("total CTC: " + totalCTC + " vezes, ou seja em: " + (float)totalCTC/total3 * 100);
		System.out.println("total CTG: " + totalCTG + " vezes, ou seja em: " + (float)totalCTG/total3 * 100);
		System.out.println("total CTT: " + totalCTT + " vezes, ou seja em: " + (float)totalCTT/total3 * 100 + "\n");
	 	
		
		//Prints G's
		System.out.println("total GAA: " + totalGAA + " vezes, ou seja em: " + (float)totalGAA/total3 * 100);
		System.out.println("total GAC: " + totalGAC + " vezes, ou seja em: " + (float)totalGAC/total3 * 100);
		System.out.println("total GAG: " + totalGAG + " vezes, ou seja em: " + (float)totalGAG/total3 * 100);
		System.out.println("total GAT: " + totalGAT + " vezes, ou seja em: " + (float)totalGAT/total3 * 100 + "\n");
		
		System.out.println("total GCA: " + totalGCA + " vezes, ou seja em: " + (float)totalGCA/total3 * 100);
		System.out.println("total GCC: " + totalGCC + " vezes, ou seja em: " + (float)totalGCC/total3 * 100);
		System.out.println("total GCG: " + totalGCG + " vezes, ou seja em: " + (float)totalGCG/total3 * 100);
		System.out.println("total GCT: " + totalGCT + " vezes, ou seja em: " + (float)totalGCT/total3 * 100 + "\n");
		
		System.out.println("total GGA: " + totalGGA + " vezes, ou seja em: " + (float)totalGGA/total3 * 100);
		System.out.println("total GGC: " + totalGGC + " vezes, ou seja em: " + (float)totalGGC/total3 * 100);
		System.out.println("total GGG: " + totalGGG + " vezes, ou seja em: " + (float)totalGGG/total3 * 100);
		System.out.println("total GGT: " + totalGGT + " vezes, ou seja em: " + (float)totalGGT/total3 * 100 + "\n");
		
		System.out.println("total GTA: " + totalGTA + " vezes, ou seja em: " + (float)totalGTA/total3 * 100);
		System.out.println("total GTC: " + totalGTC + " vezes, ou seja em: " + (float)totalGTC/total3 * 100);
		System.out.println("total GTG: " + totalGTG + " vezes, ou seja em: " + (float)totalGTG/total3 * 100);
		System.out.println("total GTT: " + totalGTT + " vezes, ou seja em: " + (float)totalGTT/total3 * 100 + "\n");
		
		
		//Prints T's
		System.out.println("total TAA: " + totalTAA + " vezes, ou seja em: " + (float)totalTAA/total3 * 100);
		System.out.println("total TAC: " + totalTAC + " vezes, ou seja em: " + (float)totalTAC/total3 * 100);
		System.out.println("total TAG: " + totalTAG + " vezes, ou seja em: " + (float)totalTAG/total3 * 100);
		System.out.println("total TAT: " + totalTAT + " vezes, ou seja em: " + (float)totalTAT/total3 * 100 + "\n");

		System.out.println("total TCA: " + totalTCA + " vezes, ou seja em: " + (float)totalTCA/total3 * 100);
		System.out.println("total TCC: " + totalTCC + " vezes, ou seja em: " + (float)totalTCC/total3 * 100);
		System.out.println("total TCG: " + totalTCG + " vezes, ou seja em: " + (float)totalTCG/total3 * 100);
		System.out.println("total TCT: " + totalTCT + " vezes, ou seja em: " + (float)totalTCT/total3 * 100 + "\n");
		
		System.out.println("total TGA: " + totalTGA + " vezes, ou seja em: " + (float)totalTGA/total3 * 100);
		System.out.println("total TGC: " + totalTGC + " vezes, ou seja em: " + (float)totalTGC/total3 * 100);
		System.out.println("total TGG: " + totalTGG + " vezes, ou seja em: " + (float)totalTGG/total3 * 100);
		System.out.println("total TGT: " + totalTGT + " vezes, ou seja em: " + (float)totalTGT/total3 * 100 + "\n");
		
		System.out.println("total TTA: " + totalTTA + " vezes, ou seja em: " + (float)totalTTA/total3 * 100);
		System.out.println("total TTC: " + totalTTC + " vezes, ou seja em: " + (float)totalTTC/total3 * 100);
		System.out.println("total TTG: " + totalTTG + " vezes, ou seja em: " + (float)totalTTG/total3 * 100);
		System.out.println("total TTT: " + totalTTT + " vezes, ou seja em: " + (float)totalTTT/total3 * 100 + "\n");
		
		
		double pAAA = (float)totalAAA/total3;
		double pAAC = (float)totalAAC/total3;
		double pAAG = (float)totalAAG/total3;
		double pAAT = (float)totalAAT/total3;
		
		double pACA = (float)totalACA/total3;
		double pACC = (float)totalACC/total3;
		double pACG = (float)totalACG/total3;
		double pACT = (float)totalACT/total3;
		
		double pAGA = (float)totalAGA/total3;
		double pAGC = (float)totalAGC/total3;
		double pAGG = (float)totalAGG/total3;
		double pAGT = (float)totalAGT/total3;
		
		double pATA = (float)totalATA/total3;
		double pATC = (float)totalATC/total3;
		double pATG = (float)totalATG/total3;
		double pATT = (float)totalATT/total3;
		
		double pCAA = (float)totalCAA/total3;
		double pCAC = (float)totalCAC/total3;
		double pCAG = (float)totalCAG/total3;
		double pCAT = (float)totalCAT/total3;
		
		double pCCA = (float)totalCCA/total3;
		double pCCC = (float)totalCCC/total3;
		double pCCG = (float)totalCCG/total3;
		double pCCT = (float)totalCCT/total3;
		
		double pCGA = (float)totalCGA/total3;
		double pCGC = (float)totalCGC/total3;
		double pCGG = (float)totalCGG/total3;
		double pCGT = (float)totalCGT/total3;
		
		double pCTA = (float)totalCTA/total3;
		double pCTC = (float)totalCTC/total3;
		double pCTG = (float)totalCTG/total3;
		double pCTT = (float)totalCTT/total3;
		
		double pGAA = (float)totalGAA/total3;
		double pGAC = (float)totalGAC/total3;
		double pGAG = (float)totalGAG/total3;
		double pGAT = (float)totalGAT/total3;
		
		double pGCA = (float)totalGCA/total3;
		double pGCC = (float)totalGCC/total3;
		double pGCG = (float)totalGCG/total3;
		double pGCT = (float)totalGCT/total3;
		
		double pGGA = (float)totalGGA/total3;
		double pGGC = (float)totalGGC/total3;
		double pGGG = (float)totalGGG/total3;
		double pGGT = (float)totalGGT/total3;
		
		double pGTA = (float)totalGTA/total3;
		double pGTC = (float)totalGTC/total3;
		double pGTG = (float)totalGTG/total3;
		double pGTT = (float)totalGTT/total3;
		
		double pTAA = (float)totalTAA/total3;
		double pTAC = (float)totalTAC/total3;
		double pTAG = (float)totalTAG/total3;
		double pTAT = (float)totalTAT/total3;
		
		double pTCA = (float)totalTCA/total3;
		double pTCC = (float)totalTCC/total3;
		double pTCG = (float)totalTCG/total3;
		double pTCT = (float)totalTCT/total3;
		
		double pTGA = (float)totalTGA/total3;
		double pTGC = (float)totalTGC/total3;
		double pTGG = (float)totalTGG/total3;
		double pTGT = (float)totalTGT/total3;
		
		double pTTA = (float)totalTTA/total3;
		double pTTC = (float)totalTTC/total3;
		double pTTG = (float)totalTTG/total3;
		double pTTT = (float)totalTTT/total3;
		
		double entropiaAA = (pAAA * (Math.log(1/pAAA)/Math.log(2))) + (pAAC * (Math.log(1/pAAC)/Math.log(2))) + (pAAG * (Math.log(1/pAAG)/Math.log(2))) + (pAAT * (Math.log(1/pAAT)/Math.log(2)));
		double entropiaCC = (pCCA * (Math.log(1/pCCA)/Math.log(2))) + (pCCC * (Math.log(1/pCCC)/Math.log(2))) + (pCCG * (Math.log(1/pCCG)/Math.log(2))) + (pCCT * (Math.log(1/pCCT)/Math.log(2)));
		double entropiaGG = (pGGA * (Math.log(1/pGGA)/Math.log(2))) + (pGGC * (Math.log(1/pGGC)/Math.log(2))) + (pGGG * (Math.log(1/pGGG)/Math.log(2))) + (pGGT * (Math.log(1/pGGT)/Math.log(2)));
		double entropiaTT = (pTTA * (Math.log(1/pTTA)/Math.log(2))) + (pTTC * (Math.log(1/pTTC)/Math.log(2))) + (pTTG * (Math.log(1/pTTG)/Math.log(2))) + (pTTT * (Math.log(1/pTTT)/Math.log(2)));

		double entropiaAC = (pACA * (Math.log(1/pACA)/Math.log(2))) + (pACC * (Math.log(1/pACC)/Math.log(2))) + (pACG * (Math.log(1/pACG)/Math.log(2))) + (pACT * (Math.log(1/pACT)/Math.log(2)));
		double entropiaAG = (pAGA * (Math.log(1/pAGA)/Math.log(2))) + (pAGC * (Math.log(1/pAGC)/Math.log(2))) + (pAGG * (Math.log(1/pAGG)/Math.log(2))) + (pAGT * (Math.log(1/pAGT)/Math.log(2)));
		double entropiaAT = (pATA * (Math.log(1/pATA)/Math.log(2))) + (pATC * (Math.log(1/pATC)/Math.log(2))) + (pATG * (Math.log(1/pATG)/Math.log(2))) + (pATT * (Math.log(1/pATT)/Math.log(2)));

		double entropiaCA = (pCAA * (Math.log(1/pCAA)/Math.log(2))) + (pCAC * (Math.log(1/pCAC)/Math.log(2))) + (pCAG * (Math.log(1/pCAG)/Math.log(2))) + (pCAT * (Math.log(1/pCAT)/Math.log(2)));
		double entropiaCG = (pCGA * (Math.log(1/pCGA)/Math.log(2))) + (pCGC * (Math.log(1/pCGC)/Math.log(2))) + (pCGG * (Math.log(1/pCGG)/Math.log(2))) + (pCGT * (Math.log(1/pCGT)/Math.log(2)));
		double entropiaCT = (pCTA * (Math.log(1/pCTA)/Math.log(2))) + (pCTC * (Math.log(1/pCTC)/Math.log(2))) + (pCTG * (Math.log(1/pCTG)/Math.log(2))) + (pCTT * (Math.log(1/pCTT)/Math.log(2)));

		double entropiaGA = (pGAA * (Math.log(1/pGAA)/Math.log(2))) + (pGAC * (Math.log(1/pGAC)/Math.log(2))) + (pGAG * (Math.log(1/pGAG)/Math.log(2))) + (pGAT * (Math.log(1/pGAT)/Math.log(2)));
		double entropiaGC = (pGCA * (Math.log(1/pGCA)/Math.log(2))) + (pGCC * (Math.log(1/pGCC)/Math.log(2))) + (pGCG * (Math.log(1/pGCG)/Math.log(2))) + (pGCT * (Math.log(1/pGCT)/Math.log(2)));
		double entropiaGT = (pGTA * (Math.log(1/pGTA)/Math.log(2))) + (pGTC * (Math.log(1/pGTC)/Math.log(2))) + (pGTG * (Math.log(1/pGTG)/Math.log(2))) + (pGTT * (Math.log(1/pGTT)/Math.log(2)));

		double entropiaTA = (pTAA * (Math.log(1/pTAA)/Math.log(2))) + (pTAC * (Math.log(1/pTAC)/Math.log(2))) + (pTAG * (Math.log(1/pTAG)/Math.log(2))) + (pTAT * (Math.log(1/pTAT)/Math.log(2)));
		double entropiaTC = (pTCA * (Math.log(1/pTCA)/Math.log(2))) + (pTCC * (Math.log(1/pTCC)/Math.log(2))) + (pTCG * (Math.log(1/pTTG)/Math.log(2))) + (pTCT * (Math.log(1/pTCT)/Math.log(2)));
		double entropiaTG = (pTGA * (Math.log(1/pTGA)/Math.log(2))) + (pTGC * (Math.log(1/pTGC)/Math.log(2))) + (pTGG * (Math.log(1/pTGG)/Math.log(2))) + (pTGT * (Math.log(1/pTGT)/Math.log(2)));

		System.out.println(entropiaAA + entropiaAC + entropiaAG + entropiaAT + entropiaCA + entropiaCC + entropiaCG + entropiaCT + entropiaGA + entropiaGC + entropiaGG + entropiaGT + entropiaTA + entropiaTC + entropiaTG + entropiaTT);
	}
}
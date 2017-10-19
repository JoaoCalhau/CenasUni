public whatEverTypeAreAnswers fifty(A,B,C,D,R){
	ArrayList<whatEverTypeAreAnswers> cenas;
	Random rand = new Random();
	if (R == A){
		cenas.add(B);
		cenas.add(C);
		cenas.add(D)
		int answer = rand.nextInt(3);
		return ( A + cenas.get(answer));
	}else{
		if (R == B){
			cenas.add(A);
			cenas.add(C);
			cenas.add(D);
			int answer = rand.nextInt(3);
			return ( B + cenas.get(answer));
		}else{
			if (R == C){
				cenas.add(A);
				cenas.add(B);
				cenas.add(D);
				int answer = rand.nextInt(3);
				return ( C + cenas.get(answer));
			}else{
				cenas.add(A);
				cenas.add(B);
				cenas.add(C);
				int answer = rand.nextInt(3);
				return ( D + cenas.get(answer));
			}
		}
	}
	cenas.clear();
}


public whatEverTypeAreAnswers telefonema(A,B,C,D,R){
	ArrayList<whatEverTypeAreAnswers> Lista;
	Random rand = new Random();
	if (nivel == "1"){
		Lista.add(A);
		Lista.add(B);
		Lista.add(C);
		Lista.add(D);
		Lista.add(R);
		Lista.add(R);
		Lista.add(R);
		Lista.add(R);
		Lista.add(R);
		Lista.add(R);
		int answer = rand.nextInt(10);
		return("Tenho quase a certeza que é a resposta " + Lista.get(answer));
	}else{
		if (nivel == "2"){
			Random answer = new Random;
			Lista.add(A);
			Lista.add(B);
			Lista.add(C);
			Lista.add(D);
			Lista.add(R);
			Lista.add(R);
			Lista.add(R);
			int answer = rand.nextInt(7);
			return("Acho que é a resposta " + Lista.get(answer));
		}else{
			Random answer = new Random;
			Lista.add(A);
			Lista.add(B);
			Lista.add(C);
			Lista.add(D);
			Lista.add(R);
			int answer = rand.nextInt(5);
			return("Não tenho a certeza mas acho que é a resposta " + Lista.get(answer));
		}
	}
	Lista.clear();
}


public String publico(A,B,C,D,R){
	Random rand = new Random();
	ArrayList<String> cenas;
	cenas.add("Votações:\n A: 35%\n B: 26%\n C: 21%\n D: 18%");
	cenas.add("Votações:\n A: 18%\n B: 35%\n C: 26%\n D: 21%");
	cenas.add("Votações:\n A: 21%\n B: 18%\n C: 35%\n D: 26%");
	cenas.add("Votações:\n A: 26%\n B: 21%\n C: 18%\n D: 35%");
	if (nivel == "1"){
		if (R == A){
			int Ar = rand.nextInt(75-60+1)+60;
			int Br = rand.nextInt(100-Ar+1)-1;
			int Cr = rand.nextint(100-Ar-Br+1)-1;
			int Dr = rand.nextInt(100-Ar-Br-Cr+1)-1;
			return ("Votações:\n A: " + Ar + "%\n B: " + Br + "%\n C: " + Cr + "%\n D: " + "%");
		}else{
			if (R == B){
				int Br = rand.nextInt(75-60+1)+60;
				int Ar = rand.nextInt(100-Ar+1)-1;
				int Cr = rand.nextint(100-Ar-Br+1)-1;
				int Dr = rand.nextInt(100-Ar-Br-Cr+1)-1;
				return ("Votações:\n A: " + Ar + "%\n B: " + Br + "%\n C: " + Cr + "%\n D: " + "%");
			}else{
				if (R == C){
					int Cr = rand.nextInt(75-60+1)+60;
					int Ar = rand.nextInt(100-Ar+1)-1;
					int Br = rand.nextint(100-Ar-Br+1)-1;
					int Dr = rand.nextInt(100-Ar-Br-Cr+1)-1;
					return ("Votações:\n A: " + Ar + "%\n B: " + Br + "%\n C: " + Cr + "%\n D: " + "%");
				}else{
					int Dr = rand.nextInt(75-60+1)+60;
					int Ar = rand.nextInt(100-Ar+1)-1;
					int Br = rand.nextint(100-Ar-Br+1)-1;
					int Cr = rand.nextInt(100-Ar-Br-Cr+1)-1;
					return ("Votações:\n A: " + Ar + "%\n B: " + Br + "%\n C: " + Cr + "%\n D: " + "%");
				}
			}	
		}	
	}else{
		if(nivel == "2"){
			if (R == A){
				int Ar = rand.nextInt(60-40+1)+40;
				int Br = rand.nextInt(100-Ar+1)-1;
				int Cr = rand.nextint(100-Ar-Br+1)-1;
				int Dr = rand.nextInt(100-Ar-Br-Cr+1)-1;
				return ("Votações:\n A: " + Ar + "%\n B: " + Br + "%\n C: " + Cr + "%\n D: " + "%");
			}else{
				if (R == B){
					int Br = rand.nextInt(60-40+1)+40;
					int Ar = rand.nextInt(100-Ar+1)-1;
					int Cr = rand.nextint(100-Ar-Br+1)-1;
					int Dr = rand.nextInt(100-Ar-Br-Cr+1)-1;
					return ("Votações:\n A: " + Ar + "%\n B: " + Br + "%\n C: " + Cr + "%\n D: " + "%");
				}else{
					if (R == C){
						int Cr = rand.nextInt(60-40+1)+40;
						int Ar = rand.nextInt(100-Ar+1)-1;
						int Br = rand.nextint(100-Ar-Br+1)-1;
						int Dr = rand.nextInt(100-Ar-Br-Cr+1)-1;
						return ("Votações:\n A: " + Ar + "%\n B: " + Br + "%\n C: " + Cr + "%\n D: " + "%");
					}else{
						int Dr = rand.nextInt(60-40+1)+40;
						int Ar = rand.nextInt(100-Ar+1)-1;
						int Br = rand.nextint(100-Ar-Br+1)-1;
						int Cr = rand.nextInt(100-Ar-Br-Cr+1)-1;
						return ("Votações:\n A: " + Ar + "%\n B: " + Br + "%\n C: " + Cr + "%\n D: " + "%");
					}
				}	
			}	
		}else{
			int answer = rand.nextInt(4);
			return(cenas.get(answer));
		}	
	}
}

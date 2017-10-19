///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class QQSM {
	/// FICHEIRO ///
	public static String path; 
	/// VARIABLES ///
	static int i = 1;	//incrementa peruntas
	static int j = 15;	//decrementa perguntas
	static String jogador;	//nome jogador
	static String current_lvl;
	static String ficheiro;
	static Questao_QQSM p;
	 /// END ///
	 
	 /// ARRAYS ///
	public static String[] amigos = {"969837575","919756348","923981269"};
	static ArrayList<Questao_QQSM> efectuadas = new ArrayList<Questao_QQSM>(15);
	static ArrayList<Questao_QQSM> jogo = new ArrayList<Questao_QQSM>();
	 static ArrayList<String> lista_ajudas = new ArrayList<String>();
	static int[] money = {500,7500,250000};
	static ArrayList<Questao_QQSM> efectuado = new ArrayList<Questao_QQSM>();
	 /// END ///

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	QQSM(){ //constructor inutil
		
	}
	public static String getPath(){
		return path;
	}
	
	public static void ajudas() throws InterruptedException{
		String[] telefones = {p.getResposta_certa(),p.getResposta_certa(),p.getResposta_certa(),"A","B","C","D"};
		String[] aleatorio = {"A","B","C","D"};
		System.out.println("\n");
		System.out.println("Ajudas disponiveis: ");
		for (int i = 0;i<lista_ajudas.size();i++){
			System.out.println(i+1+": "+lista_ajudas.get(i));
		}
		Scanner ajuda = new Scanner(System.in);
		int ajuda0 = ajuda.nextInt();
		Random rand = new Random();
		int ciclo = 0;
		for (int u = 0;u<lista_ajudas.size();u++){
			if ( (u+1) == ajuda0){
				System.out.println("\n");
				System.out.println("Escolheu "+lista_ajudas.get(u));
				System.out.println("\n");
				if (lista_ajudas.get(u).equals("publico")){
					if (current_lvl.equals("1")){
						System.out.println("a maioridade do publico votou: "+p.getResposta_certa());
					}
					if (current_lvl.equals("2")){
						System.out.println("50% do public votou em "+p.getResposta_certa());
						while (ciclo !=1){
							int valor = rand.nextInt(4);
							if (!aleatorio[valor].equals(p.getResposta_certa())){
								System.out.println("outra metade votou em: "+aleatorio[valor]);
								ciclo = 1;
							}else{
								valor = rand.nextInt(4);
							}
						}
					}
					if (current_lvl.equals("3")){
						int valor = rand.nextInt(4);
						System.out.println("publico tem opinioes diferentes, por uma pequena margem a maioridade votou: "+aleatorio[valor]);
					}
					
					lista_ajudas.remove(u);
					break;
				}
				//// TELEFONE /////
				if (lista_ajudas.get(u).equals("telefone")){
					Random telefone = new Random();
					int randoms = telefone.nextInt(3);
					System.out.println("Calling "+amigos[randoms]+".....");
					
					Thread.sleep(5000); //faz um delay de 5 segundos
					
					if (current_lvl.equals("1")){
						System.out.println("Epah... nem precisavas de telefonar, tenho 100% certeza que deves escolher a "+p.getResposta_certa());
						lista_ajudas.remove(u);
						break;
					}
					if (current_lvl.equals("2")){
						int valor3 = rand.nextInt(7);
						System.out.println("Epah... essa ja' e' mais complicada mas pah... eu diria  "+telefones[valor3]);
						lista_ajudas.remove(u);
						break;
					}
					if (current_lvl.equals("3")){
						int valor = rand.nextInt(4);
						System.out.println("Vou ser honesto contigo... nao fa�o a menor das ideias, mas tenho mais confian�a na "+aleatorio[valor]+" era o que eu escolhia");
						lista_ajudas.remove(u);
						break;
					}
					break;
				}
				
				if (lista_ajudas.get(u).equals("50/50")){
					System.out.println("reduzir para metade: ");
					while (ciclo !=1){
						int valor4 = rand.nextInt(4);
						if (!aleatorio[valor4].equals(p.getResposta_certa())){
							System.out.println(aleatorio[valor4]);
							ciclo = 1;
						}else{
							valor4 = rand.nextInt(4);
						}
				// parte do telefone done
					}
					System.out.println(p.getResposta_certa());
					lista_ajudas.remove(u);
					break;
				}
			}
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	 //por enquanto so queremos adicionar para o ficheiro
	 public static void add_pergunta() throws IOException{ //aqui vamos adicionar umas quantas perguntas ate o ficheiro estar completo!;
		 System.out.println("\n");
		 	System.out.println("nivel:");
		 	Scanner input0 = new Scanner(System.in);
		 	String nivel = input0.nextLine();
		 	while(nivel.length()>1){
		 		System.out.println("Valor errado: "+nivel);
		        System.out.println("Novo valor: ");
		        nivel = input0.nextLine();
		 	}
		 	while (nivel.charAt(0) <49 || nivel.charAt(0) >51) { //valores ascii
		 		
		        System.out.println("Valor errado: "+nivel);
		        System.out.print("Novo valor: ");
		        nivel = input0.next();
		 	}
		 	System.out.println("Pergunta");
			Scanner input1 = new Scanner(System.in);
			String pergunta = input1.nextLine();
			
			System.out.println("resposta A: ");;
			Scanner input2 = new Scanner(System.in);
			String A = input2.nextLine();
					
			System.out.println("Resposta B:");
			Scanner input3 = new Scanner(System.in);
			String B = input3.nextLine();
			
			System.out.println("resposta C:");
			Scanner input4 = new Scanner(System.in);
			String C = input4.nextLine();
			
			System.out.println("Resposta D:");
			Scanner input5 = new Scanner(System.in);
			String D = input5.nextLine();
			
			
			System.out.println("Resposta correcta: ");
			Scanner input6 = new Scanner(System.in);
			String resposta_certa = input6.nextLine();
			while (resposta_certa.length() >1){
				 System.out.println("Valor errado: "+resposta_certa);
			     System.out.print("Novo valor: ");
			        resposta_certa = input6.nextLine();
			}
				while (resposta_certa.toLowerCase().charAt(0) < 97 || resposta_certa.toLowerCase().charAt(0) >100 ){
					System.out.println("Valor errado: "+resposta_certa);
				     System.out.println("Novo valor: ");
				        resposta_certa = input6.next().toUpperCase();
				
				}
		//termina aqui
			
		//fazer formato string para ser recebido pelo constructor de Questao_QQSM
			Questao_QQSM LELS = new Questao_QQSM(nivel,pergunta,A,B,C,D,resposta_certa);
			LELS.add_para_ficheiro();
		
			
			//lista.add(new Questao_QQSM(nivel,pergunta,A,B,C,D,resposta_certa));
			//lista.get(i).add_para_ficheiro(nivel,pergunta,A,B,C,D,resposta_certa); //quere-mos so adicionar para o ficheiro por enquanto
	 }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	 private static int tamanho_ficheiro() throws IOException{
		 FileInputStream fin = new FileInputStream(path); 
		 BufferedReader br = new BufferedReader(new InputStreamReader(fin)); //ler ficheiro
		 String strLine;
		 int n_linhas = 0;
		 while((strLine = br.readLine()) !=null){
			 if (strLine.length() != 0){
			 n_linhas = n_linhas + 1;
			 }
		 }
		 return n_linhas;
	 }
	 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	 private static void add_to_array() throws IOException{
			 try{
				FileInputStream fin = new FileInputStream(path); 
				BufferedReader br = new BufferedReader(new InputStreamReader(fin)); //ler ficheiro
				Questao_QQSM LELS3;
				String strLine;
				//adiciona as linhas para o array
				int n = 1;
				while(n<=15) {
				while ((strLine=br.readLine()) != null){
					if ((strLine.length() != 0)){ 
						LELS3= new Questao_QQSM();
						
						LELS3.setNivel(strLine);
						strLine=br.readLine();
						
						LELS3.setPergunta(strLine.substring(3));
						strLine=br.readLine();
						LELS3.setRespostaA(strLine.substring(3));
						strLine=br.readLine();

						LELS3.setRespostaB(strLine.substring(3));
						strLine=br.readLine();
	
						LELS3.setRespostaC(strLine.substring(3));
						strLine=br.readLine();

						LELS3.setRespostaD(strLine.substring(3));
						strLine=br.readLine();
						
						LELS3.setResposta_certa(strLine.substring(3));
						//strLine=br.readLine();
						jogo.add(LELS3);
					}else{
							 continue;
						 }
				}
				n++;
				}
						//if (br.toString().toLowerCase().startsWith("r"));
						//if (br.toString()=="\n");
						//this.resposta_certa = this.resposta_certa.substring(3);
						
						
				}catch (IOException e){
					System.out.println("Error found: File not found");
					System.out.println("1. File not in /src directory");
					System.out.println("2. File not spelled correctly");
					System.out.println("3. File does not exist");
					System.out.println("\nPlease check");
				}
		 }
		 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	 //nome do jogador
	 private static String jogador(){
		 System.out.println("nome do jogador: ");	
		Scanner nome = new Scanner(System.in);
		jogador = nome.nextLine();
		return jogador;
	 }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 private static void verifica_nivel() {
		 //isto depois vai ser util
		 //i told you
		 //alterar para 15
		 if (i<=3){
			 current_lvl = "1";
		 }
		 if (i>3 && i<=7){
			 current_lvl = "2";
		 }
		 if (i>7 && i<=15){
			 current_lvl ="3";
		 }
		 if (i>15){
			 System.out.println("tens aqui um bug pah");
			 System.exit(0);
		 }
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void patamar(){
		if (current_lvl.equals("2")){
			System.out.println("Perdes-te mas conseguiste assegurar: "+money[0]);
		}
		if (current_lvl.equals("3")){
			System.out.println("Perdes-te mas conseguiste assegurar: "+money[1]);
		}
		if ( i==15){
			System.out.println("Parabens! ");
			System.out.println("Ganhaste o jogo de Quem quer ser milionario e ganhas-te o grande premio de "+ money[2]);
		}
	}
	public static void play() throws InterruptedException{
		 //objecto temporario
		Random rand= new Random();
		while (i <=15){
			verifica_nivel();
			int random = rand.nextInt(j) + 1;
			p = jogo.get(random-1);
			if (current_lvl.equals(p.getNivel())){
				System.out.println("Pergunta "+i);
				System.out.println("Nivel "+p.getNivel());
				System.out.println("P: "+ p.getPergunta());
				System.out.println("A: "+p.getRespostaA());
				System.out.println("B: "+p.getRespostaB());
				System.out.println("C: "+p.getRespostaC());
				System.out.println("D: "+p.getRespostaD());
				if (lista_ajudas.size() != 0){
					System.out.println("Deseja utilizar ajudas? 1 - sim, any other key - nao");
					Scanner pergunta = new Scanner(System.in);
					String pergunta0 = pergunta.next();
					if (pergunta0.equals("1")){
						ajudas();
					}
				}
				System.out.println("\n");
				System.out.print("Sua resposta: ");
				Scanner rc = new Scanner(System.in);
				String rces = rc.nextLine();
				while(rces.length()>1){
					System.out.println("input errado: ");
					System.out.print("Novo input: ");
					rces = rc.nextLine();
				}
				while (rces.toLowerCase().charAt(0) < 97 || rces.toLowerCase().charAt(0) >100 ){
					System.out.println("Input errado: "+rces);
				    System.out.println("Nova resposta: ");
				    rces = rc.nextLine();
				}
				if (p.getResposta_certa().toLowerCase().equals(rces.toLowerCase())){
					System.out.println("\n");
					System.out.println("Correct!");
					System.out.println("1 - continue");
					System.out.println("Any other key - give up");
					Scanner decisao = new Scanner(System.in);
					String decisao1 = decisao.nextLine() ;

					if (!decisao1.equals("1")){
						patamar();
						break;
					}
					i++;
					j--;
				}else{
					System.out.println("Infelizmente erraste a pergunta!");
					if (i>1){
						patamar();
						break;
					}else{
						System.out.println("\n");
						System.out.println("Infelizmente nao chegaste ao primeiro patamar de seguran�a por isso ganhas te 0 euros");
						System.out.println("Obrigado por jogares!");
						System.out.println("\n");
						break;
					}
				}
				efectuadas.add(jogo.get(random-1));
				jogo.remove(random-1);

				}
		}
		patamar();
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//so permite criar ficheiro .txt
	private static void ficheiro() throws IOException {
		System.out.println("Nome do ficheiro ");
		System.out.println("Se o ficheiro nao existir na directoria, esse ficheiro � criado: ");
		Scanner fin = new Scanner(System.in);
		path = fin.nextLine();
		while(path.length()<=4){
			System.out.println("String lenght to small");
			System.out.print("novo input: ");
			path = fin.nextLine();
		}
		if (!path.substring(path.length()-4).equals(".txt")){
			path = path + ".txt";
		}
		File fines = new File(path);
		if (fines.exists()){
			fines.createNewFile();		
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//MAIN, IT ALL STARTS HERE!
	public static void main(String args[]) throws IOException, InterruptedException{
		lista_ajudas.add("50/50");
		lista_ajudas.add("telefone");
		lista_ajudas.add("publico");
		for(;;){
			System.out.println("\n");
			
			jogo = new ArrayList<Questao_QQSM>();
			System.out.println("Bem vindo ao Quem Quer Ser Milionario! "
				+ "" + "\n" +"\n"+ "Option 1: Start" +  "\n" +  "Option 2: Add question" + "\n"+ "Option 3: Exit");
		
			
			Scanner case1 = new Scanner(System.in);
			String input = case1.next();
			while(input.length()>1){
				System.out.println("Valor errado: "+ input);
				System.out.print("Novo valor: ");
				input = case1.next();
			}
			while (input.charAt(0) <49 || input.charAt(0) >51) { //valores ascii
				//fix this
		        System.out.print("Valor errado \n");
		        System.out.println(input);
		        input = case1.next();
			}
			/*
			//restri�ao que verifica se o ficheiro tem pelo menos 15 perguntas
			if (input.equals("1") && tamanho_ficheiro()<105){
				while (input.equals("1") || tamanho_ficheiro() <105){
					System.out.println("Numero de perguntas no ficheiro: "+ tamanho_ficheiro() / 7);
					System.out.println("Deseja sair ou adicionar?  ");
					input = case1.next();
					while(!input.equals("3")){
						System.out.println("valor errado: "+input);
						System.out.print("novo valor: ");
						input = case1.next();
					}
					System.out.println("perguntas insuficientes ( minimo 15 ), adicione: ");
					add_pergunta();
					
				}
			}
			*/
			switch(Integer.parseInt(input)){	
			case 1:
				ficheiro();
				if (input.equals("1") && tamanho_ficheiro()<105){
					while (input.equals("1") || tamanho_ficheiro() <105){
						System.out.println("Numero de perguntas no ficheiro: "+ tamanho_ficheiro() / 7);
						System.out.println("Deseja sair ou adicionar?  ");
						input = case1.next();
						while(!input.equals("3")){
							System.out.println("valor errado: "+input);
							System.out.print("novo valor: ");
							input = case1.next();
						}
						System.out.println("perguntas insuficientes ( minimo 15 ), adicione: ");
						add_pergunta();
					}
				}
				jogador();
				add_to_array();
				play();
				break;
			case 2:
				add_pergunta();
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
	}
	
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//to do list
		//testar
		// testar com 15 perguntas
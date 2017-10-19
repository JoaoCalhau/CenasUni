package so2;


import java.net.*;
import java.io.*;
import java.util.Scanner;

public class VeiculosClient {
	private String address= "localhost";
	private int sPort= 0;

	public VeiculosClient(String add, int p) {
		address= add;
		sPort=p;
	}


    public static void main(String[] args){
	if (args.length < 2) {
		System.err.println("Argumentos insuficientes:  java VeiculosClient ADDRESS PORT");
		System.exit(1);
	}
	
	try {
		String addr= args[0];
		int p= Integer.parseInt(args[1]);	
	
		VeiculosClient cl= new VeiculosClient(addr,p);

		cl.menu( );   // interage com o utilizador
	}
	catch (Exception e) {
	    System.out.println("Problema no formato dos argumentos");
	    e.printStackTrace();


	}
    }



	public void menu() {
	    try {
		while (true) {  // ciclo: pede ao utilizador...
		    System.out.print("\n\n --- MENU --- \n"+
				       "registar - enviar novo registo para o servidor\n"+
				       "consultar - obter dados sobre o proprietario de um veiculo\n\n> ");
		    
		    // ler a opcao
                    Scanner sc = new Scanner(System.in);
		    String read = sc.nextLine();
		    //String op= new String(b,0,lidos-1);
		    
		    if (read.equals("registar")) {
			// ler dados
			String s= null;

			System.out.println("matricula: ");
			String matricula = sc.nextLine();
			

			System.out.println("nome do proprietario: ");
			String nome = sc.nextLine();

			System.out.println("ano de matricula: ");
			String cenas = sc.nextLine();
                        int ano = Integer.parseInt(cenas);
			
			PedidoDeRegisto pr= new PedidoDeRegisto(new Registo(matricula,nome,ano));
			enviaPedido( pr );
		    }
		    else if (read.equals("consultar")) {
			System.out.println("matricula: ");

			String matricula = sc.nextLine();

			PedidoDeConsulta pc = new PedidoDeConsulta(matricula);
			enviaPedido( pc );
		    }
		    else 
			System.out.println("opcao invalida");
		    
		}

	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }
	}



    
	public void enviaPedido(Pedido p) {
	    try {
		Socket s= new Socket(address, sPort);
		// ja esta connected
		// que Streams usar????
                
                ObjectOutputStream socketOut = new ObjectOutputStream(s.getOutputStream());
                socketOut.writeObject(p);
                
		// escrever a mensagem?
		// ler a resposta e mostrar o resultado
                ObjectInputStream socketIn = new ObjectInputStream(s.getInputStream());
                Object rec = socketIn.readObject();
                
                String resposta;
                if(rec instanceof String) {
                    resposta = (String) rec;
                } else if(rec instanceof Registo) {
                    Registo r = (Registo) rec;
                    resposta = r.toString();
                } else {
                    resposta = "Error bitch!";
                }
		// fechar o socket
                s.close();
                
                System.out.println(resposta);
	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }

	}

}

package so2;

import java.io.*;
import java.net.*;


public class EchoServerConcorrente {

    private int serverPort;	
    
    public EchoServerConcorrente(int p) {
	serverPort= p;		
    }
    
    
    public static void main(String[] args){
	System.err.println("SERVER...");
	if (args.length<1) {
	    System.err.println("Missing parameter: port number");	
	    System.exit(1);
	}
	int p=0;
	try {
	    p= Integer.parseInt( args[0] );
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.exit(2);
	}
	
	
	EchoServerConcorrente serv= new EchoServerConcorrente(p);
	serv.servico();   // activa o servico
    }

    
    // activa o servidor no porto indicado em "serverPort"
    public void servico() {
	
	// um servidor TCP: ver outro exemplo no livro
	
        ServerSocket server= null;

        try {
	    // inicializar o socket e associa-lo ao porto local
            server= new ServerSocket(serverPort);
	    
	    // ciclo de atendimento dos pedidos
	    while (true) {

		Socket data= null;

                data = server.accept();
                System.err.println("\t chegou um pedido");


                // o atendimento será delegado para um novo objecto...

		// EXERCICIO:
		// a) criar instancia da classe que atende pedidos
		//    e invocar o metodo para realizar o atendimento  (ainda iterativo)
  
                AtendedorDePedidos adp = new AtendedorDePedidos(data);
                adp.start();

 



		// EXERCICIO:   (nao faca esta parte antes de executar a anterior)
		// b) a classe de atendimento vai estender a classe Thread
		//    precisa adicionar-lhe um metodo run(), que invoque o metodo de atendimento
		//    neste local, em vez de invocar diretamente o atendimento, vai ativar a thread, com start()
				   // ... esta thread (principal) segue em frente





                // ... e volta ao ciclo de atendimento
            }

	}
	catch(Exception e) {
	    e.printStackTrace();
	    System.err.println("PROBLEMA no funcionamento do servidor: "+e);
	}
    }


}


// esta classe nao pode ser publica se esta num ficheiro que ja tem uma classe publica!
class AtendedorDePedidos extends Thread {

    Socket data;

    public AtendedorDePedidos(Socket data) {
        this.data= data;
    }

    public void atendePedido() {
        try {
            DataOutputStream sout = new DataOutputStream(data.getOutputStream());
            BufferedReader breader = new BufferedReader(new InputStreamReader(data.getInputStream()));

            String msgEcho = breader.readLine();
            System.err.println("\t\t pedido: " + msgEcho);


            // espera para simular demora no atendimento do pedido
            Thread.sleep(4000);


            msgEcho = "Ola! " + msgEcho + " Adeus";
            System.err.println("\t\t a resposta vai ser: " + msgEcho);

            sout.writeUTF(msgEcho);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("PROBLEMA no atendimento do pedido: " + e);
        } 
        finally {  // haja ou nao excepcao
            // muito importante: fechar o socket de dados
            if (data != null) {
                try {
                    data.close();        //  MUITO IMPORTANTE... fechar sempre
                } catch (Exception ec) {
                    System.err.println(ec);
                }
            }
        }
        


    }
    
    public void run() {
        atendePedido();
    }


}
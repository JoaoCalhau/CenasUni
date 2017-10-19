package so2;

import java.io.*;
import java.net.*;
import java.util.Vector;

public class VeiculosServer extends Thread{
    private int serverPort;	
    
    private Vector<Registo> repositorio;
    
    public VeiculosServer(int p) {
	serverPort= p;		
	repositorio = new Vector<Registo>(); // INICIALIZE o Vector
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
	
	
	VeiculosServer serv= new VeiculosServer(p);
        serv.start();   // activa o servico
    }
    
    





    public void servico() {

	try {
	    // inicializa o socket para receber ligacoes
             ServerSocket ssock = new ServerSocket(serverPort);
	  
	    while (true) {
		// espera uma ligacao
		// ... accept()
		Socket s = ssock.accept();
                
		try {
		    Object objPedido= null;
		    // le os dados do pedido, como um OBJECTO "objPedido"		

                    ObjectInputStream socketIn = new ObjectInputStream(s.getInputStream());
                    objPedido = socketIn.readObject();
		    
		    // apreciar o objecto com o pedido recebido:
		    if (objPedido==null)
			System.err.println("PEDIDO NULL: esqueceu-se de alguma coisa");
		    
		    if (objPedido instanceof PedidoDeConsulta) {
			PedidoDeConsulta pc = (PedidoDeConsulta) objPedido;
			
                        
                        ObjectOutputStream socketOut = new ObjectOutputStream(s.getOutputStream());
                        boolean found = false;
			// procurar o registo associado a matricula pretendida
                        for(Registo r : repositorio) {
                            if(r.getMatricula().equals(pc.getMatricula())) {
                                socketOut.writeObject(r);
                                found = true;
                                break;
                            }
                        }
                        
                        if(!found) {
                            socketOut.writeObject(null);
                        }
                        
			// pesquisar no servidor (Vector, mais tarde num ficheiro)

			
			// enviar objecto Cliente via socket		    
			// se encontra devolve o registo, se não, devolve um novo objecto ou string a representar que nao encontrou


			
		    }
		    else if (objPedido instanceof PedidoDeRegisto) {
			PedidoDeRegisto pr = (PedidoDeRegisto) objPedido; // ...

                        ObjectOutputStream socketOut = new ObjectOutputStream(s.getOutputStream());
                        
                        if(repositorio.contains(pr)) {
                            socketOut.writeObject("Já está registado...");
                        } else {
                            repositorio.add(pr.getRegisto());
                            socketOut.writeObject("Registado!");
                        }
			// ver se ja existia registo desta matricula

			
			// adicionar ao rep local (se nao e' uma repeticao)

			
			// responder ao cliente


		    }
		    else
			System.out.println("PROBLEMA");
		    
                }
                catch (Exception exNoAtendimento) {
                    exNoAtendimento.printStackTrace();
                }
                finally {  // fechar o socket de dados
                    // fechar o socket de dados dedicado a este cliente:
                    try {
                        s.close();
                        //AQUI: fechar o socket de dados
                    }
                    catch (Exception e002) {
                    }
                }
                
		
	    
		
	    }  // ... ciclo de atendimento
	
	}
	catch (Exception problemaBindAccept) {
	    problemaBindAccept.printStackTrace();
	}

    }
    
    public void run() {
        servico();
    }


}

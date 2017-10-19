package so2;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class EchoServer {

    private int serverPort;	
    
    public EchoServer(int p) {
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
		} catch (Exception e) {
		    e.printStackTrace();
		    System.exit(2);
		}
		
		
		EchoServer serv= new EchoServer(p);
		serv.servico();   // activa o servico
    }

    
    // activa o servidor no porto indicado em "serverPort"
    public void servico() {
	
	// exercicio 2: inicializar um socket para aceitar ligacoes...

    	try {
    		ServerSocket ssock = new ServerSocket(serverPort);

	    	while (true) {
		    	Socket s = ssock.accept();
		    	InputStream socketIn = s.getInputStream();
		    	byte[] b = new byte[256];
		    	int i = socketIn.read(b, 0, 256);
		    	String read = new String(b, 0, i);
		    	System.out.println("Mensagem recebida de: " + s.toString());
		    	System.out.println("Mensagem: " + read);
		    	System.out.println("");

		    	OutputStream socketOut = s.getOutputStream();
		    	String string = "Message received";
		    	socketOut.write(string.getBytes());
	    	}
   		
	    } catch (Exception e) {
	    	System.err.println("Woops...");
	    	System.exit(1);
	    }

    }


}

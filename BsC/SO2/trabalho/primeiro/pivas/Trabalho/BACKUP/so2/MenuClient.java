package so2;


import java.util.ArrayList;
import java.util.Vector;

public class MenuClient {

    public static void main(String args[]) {
	String regHost = "localhost";
	String regPort = "9000";  // porto do binder
	String frase= "";

	if (args.length !=2) { // requer 2 argumentos
	    System.out.println
		("Usage: java so2.rmi.PalavrasClient registryHost registryPort frase");
	    System.exit(1);
	}
	regHost= args[0];
	regPort= args[1];


	try {
	    // objeto que fica associado ao proxy para objeto remoto
	    MainMenu obj =
		(MainMenu) java.rmi.Naming.lookup("rmi://" + regHost + ":" + 
						  regPort + "/registos");
	    

	    // invocacao de metodos remotos
            obj.menu();

	    

	} 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}

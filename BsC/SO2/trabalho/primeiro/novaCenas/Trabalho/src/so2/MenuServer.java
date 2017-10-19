package so2;

import java.rmi.Remote;


public class MenuServer {

    public static void main(String args[]) {
        
	int regPort= 1099; // default RMIRegistry port

	if (args.length !=1) { // obrigar 'a presenca de um argumento
	    System.out.println("Usage: java so2.rmi.PalavrasServer registryPort");
	    System.exit(1);
	}
	

	try {
	    regPort=Integer.parseInt(args[0]);

	    ListaQuestionariosImpl obj= new ListaQuestionariosImpl();

            java.rmi.registry.LocateRegistry.createRegistry(regPort);            

	    java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(regPort);

	    registry.rebind("quest", obj);  // NOME DO SERVICO

	    System.out.println("Bound RMI object in registry");

            System.out.println("servidor pronto");
	} 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
    
}

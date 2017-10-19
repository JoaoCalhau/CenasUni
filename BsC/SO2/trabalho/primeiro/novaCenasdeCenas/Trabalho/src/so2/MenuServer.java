package so2;

import java.rmi.RemoteException;
import java.util.Scanner;


public class MenuServer {

    public static void main(String args[]) throws Exception {
        
	int regPort= 1099;

	if (args.length != 5) { 
	    System.out.println("Usage: java so2.MenuServer registryPort DBHost DBName DBUser DBPw");
	    System.exit(1);
	}
	

	try {
            //application.args=9000 alunos.di.uevora.pt l31621 l31621 12345
            
            System.out.println(java.net.InetAddress.getLocalHost());
            
	    regPort=Integer.parseInt(args[0]);

	    //ListaQuestionariosImpl obj= new ListaQuestionariosImpl();
            
            ListaQuestionariosImpln obj2 = new ListaQuestionariosImpln(args[1], args[2], args[3], args[4]);

            java.rmi.registry.LocateRegistry.createRegistry(regPort);            
            
	    java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(regPort);
            
	    registry.rebind("quest", obj2);

	    System.out.println("Bound RMI object in registry");

            System.out.println("servidor pronto");
            
            System.out.println("(Para fechar o servidor, basta escrever 'exit')");
            System.out.println("('exit' este que também serve para guardar os questionarios em memória)");
            
            Scanner sc = new Scanner(System.in);
            
            while(!sc.nextLine().toUpperCase().equals("EXIT"))
                sc.next();
            
            obj2.close();
            
            System.exit(0);
	} 
	catch (NumberFormatException | RemoteException e) {
            e.printStackTrace();
	    System.err.println("Oops! Something went wrong!");
	}
    }
    
}

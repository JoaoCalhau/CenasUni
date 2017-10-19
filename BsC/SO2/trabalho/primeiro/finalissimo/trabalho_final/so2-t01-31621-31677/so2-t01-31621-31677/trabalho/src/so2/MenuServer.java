package so2;

import java.rmi.RemoteException;
import java.util.Scanner;


public class MenuServer {

    public static void main(String args[]) throws Exception {
        
	int regPort= 1099;
        String DB_HOST= "alunos.di.uevora.pt";
        String DB_NAME= "l31621";
        String DB_USER= "l31621";
        String DB_PW= "12345";

	if (args.length != 5) { 
	    System.out.println("Usage: java so2.MenuServer registryPort DBHost DBName DBUser DBPw");
            System.out.println("Exemple: java so2.MenuServer 31621 alunos.di.uevora.pt l31621 l31621 12345");
	    System.exit(1);
	}

	try {
            System.out.println(java.net.InetAddress.getLocalHost());

	    regPort= Integer.parseInt(args[0]);

            DB_HOST= args[1];
            DB_NAME= args[2];
            DB_USER= args[3];
            DB_PW= args[4];
            
            OperacoesDBImpl obj = new OperacoesDBImpl(DB_HOST, DB_NAME, DB_USER, DB_PW);

            java.rmi.registry.LocateRegistry.createRegistry(regPort);            
            
	    java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(regPort);
            
	    registry.rebind("quest", obj);

	    System.out.println("Bound RMI object in registry");

            System.out.println("servidor pronto");
            
            System.out.println("(Para fechar o servidor, basta escrever 'exit')");
            
            Scanner sc = new Scanner(System.in);
            
            while(!sc.nextLine().toUpperCase().equals("EXIT"))
                sc.next();
            
            obj.close();
            
            System.exit(0);
	} catch (NumberFormatException e) {
	    System.err.println("Oops! Number Format Exception!");
	} catch(RemoteException e) {
            System.out.println("Oops! RMI Remote Exception!");
        }
    }
}
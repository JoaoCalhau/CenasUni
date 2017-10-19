/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservas;

/**
 *
 * @author joaoc
 */
public class reservasServer {
    
    public static void main(String args[]) {
        
        int regPort = 1099;
        
        if (args.length != 1) {
            System.out.println("Usage: java so2.rmi.PalavrasServer registryPort");
	    System.exit(1);
        }
        
        try {
            regPort = Integer.parseInt(args[0]);
            
            reservasParaJantar obj = new reservasParaJantarImpl();
            
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(regPort);
            
            registry.rebind("registos", obj);
            
            System.out.println("Bound RMI object to registry");
            
            System.out.println("servidor pronto");
        } catch(Exception e) {
            System.out.println("Oops");
        }
    }
}

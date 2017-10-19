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
public class reservasClient {
    
    public static void main(String args[]) {
        String regHost = "localhost";
        String regPort = "9000";
        String reserva = "";
        
        
        if (args.length != 3) {
            System.out.println
		("Usage: java so2.rmi.PalavrasClient registryHost registryPort frase");
	    System.exit(1);
        }
        
        regHost = args[0];
        regPort = args[1];
        reserva = args[2];
        
        try {
           
            reservasParaJantar obj =
		(reservasParaJantar) java.rmi.Naming.lookup("rmi://" + regHost + ":" + 
						  regPort + "/registos");
            
            obj.addReserve(reserva);
            System.out.println("Reserva feita!");
            
            String print = obj.getListReserves().toString();
            System.out.println("Lista: " + print);
            
            int numero = obj.getNumReserves();
            System.out.println("Numero de reservas: " + numero);
            
        } catch(Exception e) {
            System.out.println("Oops");
        }
    }
}

package so2;


import java.util.ArrayList;
import java.util.Vector;

public class ReservasClient {

    public static void main(String args[]) {
	String regHost = "localhost";
	String regPort = "9000";  // porto do binder
	String frase= "";

	if (args.length !=3) { // requer 3 argumentos
	    System.out.println
		("Usage: java so2.rmi.PalavrasClient registryHost registryPort frase");
	    System.exit(1);
	}
	regHost= args[0];
	regPort= args[1];
	frase= args[2];
        String[] teste;
        teste = frase.split(" ");


	try {
	    // objeto que fica associado ao proxy para objeto remoto
	    ReservasParaJantar obj =
		(ReservasParaJantar) java.rmi.Naming.lookup("rmi://" + regHost + ":" + 
						  regPort + "/registos");
	    

	    // invocacao de metodos remotos
            for(int i=0; i < teste.length;i++){
                obj.reservarNome(teste[i]);
            }

	    ArrayList<String> v= obj.listaDeNomes();
	    System.out.println(v);
            
            int x= obj.numeroReservas();
	    System.out.println(x);

	    

	} 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}

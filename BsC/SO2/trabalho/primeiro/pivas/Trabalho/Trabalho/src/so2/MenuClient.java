package so2;

import java.rmi.RemoteException;
import java.util.Scanner;

public class MenuClient {
    
    static String password = "1234";
    static String isIt;

    private static void toAdmin(Scanner sc) {
            System.out.println("Insira a password:");
            String s = sc.nextLine();
            if(s.equals(password)){
                    isIt = "Admin";
                    System.out.println("Tem agora privilegios de Admin.");
            } else
                    System.out.println("Password Errada!");
    }

    private static void listarComandos() {
            System.out.println("Comandos possiveis:\n'listar'\n'responder'");
            if(isIt.equals("Client"))
                    System.out.println("'admin'");
            else if(isIt.equals("Admin"))
                    System.out.println("'criar'\n'apagar'\n'logout'");
            System.out.println("'exit'");
    }

    private static void listarQuestionarios(ListaQuestionarios obj) throws RemoteException {
            obj.listarQuestionarios();
    }

    private static void responderQuestionarios(ListaQuestionarios obj, Scanner sc) throws RemoteException {
            //to do
            System.out.println("Qual o numero do questionario a que pretende responder?");
            String s = sc.nextLine();
            int num = Integer.parseInt(s);
            obj.respondeQuestionario(num); 
    }

    private static void criarQuestionario(ListaQuestionarios obj) throws RemoteException {
            //to do

            obj.addQuestionario();

    }

    private static void apagarQuestionario(ListaQuestionarios obj, Scanner sc) throws RemoteException {
            //to do

            System.out.println("Qual é o numero do questionario que quer apagar?");
            String s = sc.nextLine();
            int num = Integer.parseInt(s);
            obj.removeQuestionario(num);
    }

    private static void logoutAdmin() {
            isIt = "Admin";
            System.out.println("Tem agora privilegios basicos de cliente.");
    }

    private static void exitProgram() {
            System.exit(0);
    }

    public static void mainMenu(ListaQuestionarios obj) throws RemoteException {

            isIt = "Client";
            System.out.println("Bem vindo a plataforma de Questionarios!\n"
                    + "Encontra-se neste momento no Menu.\n"
                    + "(Para saber os comandos escreva 'help')");
            Scanner scanner = new Scanner(System.in);
            String sc;
            while(true) {
                    sc = scanner.nextLine();
                    if(sc.toUpperCase().equals("ADMIN") && isIt.equals("Client")) {
                            //fazer login com privilegios de admin

                            toAdmin(scanner);

                    } else if(sc.toUpperCase().equals("HELP")) {
                            //listar todos os comandos possiveis

                            listarComandos();

                    } else if(sc.toUpperCase().equals("LISTAR")) {
                            //listar os questionarios disponiveis

                            listarQuestionarios(obj);

                    } else if(sc.toUpperCase().equals("RESPONDER")) {
                            //responder aos questionarios

                            responderQuestionarios(obj, scanner);

                    } else if(sc.toUpperCase().equals("CRIAR") && isIt.equals("Admin")) {
                            //criar um questionario com permissao de admin

                            criarQuestionario(obj);

                    } else if(sc.toUpperCase().equals("APAGAR") && isIt.equals("Admin")) {
                            //apagar um questionario com permissao de admin

                            apagarQuestionario(obj, scanner);

                    } else if(sc.toUpperCase().equals("LOGOUT") && isIt.equals("Admin")) {
                            //fazer logout de admin e voltar a cliente

                            logoutAdmin();

                    } else if(sc.toUpperCase().equals("EXIT")) {
                            //sair do programa

                            exitProgram();

                    } else {
                        System.out.println("Comando não reconhecido...");
                    }
            }
    }
        


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
            ListaQuestionarios obj =
            (ListaQuestionarios) java.rmi.Naming.lookup("rmi://" + regHost + ":" + 
                                          regPort + "/quest");
            
            mainMenu(obj);
        
        } catch(Exception e) {
            System.out.println("Oops! Something went wrong!");
        }


    }
}

package so2;

import java.rmi.RemoteException;
import java.util.Scanner;

public class MenuClient {
    
    static String password = "1234";
    static String isIt;

    private static void toAdmin(Scanner sc) {
        System.out.println("Insira a password:");
        String s = sc.nextLine();
        if(s.equals(password)) {
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
        String listar = obj.listarQuestionarios();
        System.out.println(listar);
    }

    private static void responderQuestionarios(ListaQuestionarios obj, Scanner sc) throws RemoteException {
        System.out.println("Qual o numero do questionario a que pretende responder?");
        String s = sc.nextLine();
        int num = Integer.parseInt(s);
        obj.respondeQuestionario(num); 
    }

    private static void criarQuestionario(ListaQuestionarios obj) throws RemoteException {
        
        Questionario novo = new Questionario();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Quer guardar o Questionario? (y/n)");
        String guardar= sc.nextLine();
        boolean ciclo=true;
        boolean adicionar = false;
        while(ciclo){
            switch (guardar.toUpperCase()) {
                case "Y":
                    System.out.println("Questionario adicionado!");
                    ciclo=false;
                    adicionar = true;
                    break;
                case "N":
                    System.out.println("Questionario nao foi adicionado!");
                    ciclo=false;
                    break;
                default:
                    System.out.println("Insira y/n!");
                    guardar= sc.nextLine();
                    break;
            }
        }
        if(adicionar)
            obj.addQuestionario(novo);

    }
    
    private static int scan(Scanner sc, int start, int end) {
        int valor=-1;
        System.out.println("Insira valor int entre "+ start +" e "+ end);
        while(sc.hasNext()){
            if(sc.hasNextInt()) {
                valor = sc.nextInt();
                if(valor >= start && valor <= end ) {
                    System.out.println("Resposta Aceite");
                    return valor;
                }
            } else {
                System.out.println("Insira valor int entre "+ start +" e "+ end);
                sc.next();
            }
        }
        return valor;
    }
    
    private static String removerConfirm(Scanner sc, String nome){
            boolean ciclo=true;
            System.out.println("Quer mesmo remover o questionario "+ nome + "? (y/n)");
            String satisfeito= sc.nextLine();
            while(ciclo) {
                if(satisfeito.toUpperCase().equals("Y")) {
                    System.out.println("Questionario removido!");
                    return satisfeito.toUpperCase();
                } else if(satisfeito.toUpperCase().equals("N")) {
                    System.out.println("Questionaro nao removido!");
                    return satisfeito.toUpperCase();
                    
                } else {
                    System.out.println("Insira y/n!");
                    satisfeito= sc.nextLine();
                }
            }
            return satisfeito.toUpperCase();
    }

    private static void apagarQuestionario(ListaQuestionarios obj, Scanner sc) throws RemoteException {
        int tamanho= obj.returnContador();
        if(tamanho==0) {
            System.out.println("Nao existem questionarios guardados!");
            
        } else {
            System.out.println("Qual é o numero do questionario que quer apagar?");
            int valor = scan(sc, 1, tamanho);
            String result = obj.returnQuestionarioNome(valor-1);
            String remover = removerConfirm(sc, result);
            if("Y".equals(remover))
                obj.removeQuestionario(valor-1);
        }
    }

    private static void logoutAdmin() {
        isIt = "Admin";
        System.out.println("Tem agora privilegios basicos de cliente.");
    }

    private static void exitProgram() {
        System.out.println("Adeus");
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

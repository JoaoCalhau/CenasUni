package so2;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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
        System.out.println("Comandos possiveis:\n'listar'\n'responder'\n'ver'\n'media'\n'vezes'");
        if(isIt.equals("Client"))
                System.out.println("'admin'");
        else if(isIt.equals("Admin"))
                System.out.println("'criar'\n'apagar'\n'logout'");
        System.out.println("'exit'");
    }

    private static void listarQuestionarios(ListaQuestionariosn obj) throws RemoteException {
        Scanner sc = new Scanner(System.in);
        int tamanho= obj.returnContador();
        if(tamanho==0)
            System.out.println("Nao existem questionarios guardados!");
        else {
            String listar = obj.listarQuestionarios();
            System.out.println(listar);
        }
    }

    private static void responderQuestionarios(ListaQuestionariosn obj) throws RemoteException {
        //to do
        Scanner sc = new Scanner(System.in);
        int tamanho= obj.returnContador();
        if(tamanho==0) {
            System.out.println("Nao existem questionarios guardados!");
        } else {
            System.out.println("Qual o numero do questionario a que pretende responder?");
            int curr = obj.returnCurr();
            int valor = scan(sc, 1, curr);
            Questionario temp = obj.returnQuestionario(valor);
            if(temp == null)
                System.out.println("Mas questionario ja foi apagado");
            else {
                temp.responderPerguntas();
                int respostas[] = temp.getRespostas();
                obj.respondeQuestionario(valor, respostas);
            }

        }
    }
    
    private static void verQuestoesQuestionario(ListaQuestionariosn obj) throws RemoteException {
        Scanner sc = new Scanner(System.in);
        int tamanho= obj.returnContador();
        if(tamanho==0) {
            System.out.println("Nao existem questionarios guardados!");
        } else {
            System.out.println("Qual o numero do questionario que pretende ver as questoes?");
            int curr = obj.returnCurr();
            int valor = scan(sc, 1, curr);
            Questionario temp = obj.returnQuestionario(valor);
            if(temp == null)
                System.out.println("Mas questionario ja foi apagado");
            else {
                String perguntas = temp.verPerguntas();
                System.out.println(perguntas);
            }
        }
    }
    
    private static void verMediaQuestionario(ListaQuestionariosn obj) throws RemoteException {
        //to do
        Scanner sc = new Scanner(System.in);
        int tamanho= obj.returnContador();
        if(tamanho==0) {
            System.out.println("Nao existem questionarios guardados!");
        } else {
            System.out.println("Qual o numero do questionario que pretende ver a media das questoes?");
            int curr = obj.returnCurr();
            int valor = scan(sc, 1, curr);
            Questionario temp = obj.returnQuestionario(valor);
            if(temp == null)
                System.out.println("Mas o questionario ja foi apagado");
            else {
                String perguntas = temp.verMedia();
                System.out.println(perguntas);
            }
        }
    }
    
    
    private static void verVezesQuestionario(ListaQuestionariosn obj) throws RemoteException {
        Scanner sc = new Scanner(System.in);
        int tamanho= obj.returnContador();
        if(tamanho==0) {
            System.out.println("Nao existem questionarios guardados!");
        } else {
            System.out.println("Qual o numero do questionario que pretende ver quantas vezes foi respondido?");
            int curr = obj.returnCurr();
            int valor = scan(sc, 1, curr);
            Questionario temp = obj.returnQuestionario(valor);
            if(temp == null)
                System.out.println("Mas o questionario ja foi apagado");
            else {
                int vezes = temp.quantRespostas();
                System.out.println("O Questionario " + temp.getNome() + " foi respondido " + vezes +" vez(es)!");
            }
        }
    }
    

    private static void criarQuestionario(ListaQuestionariosn obj) throws RemoteException {
        
        Questionario novo = new Questionario();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Quer guardar o Questionario? y/n");
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
        while(sc.hasNext()) {
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
            System.out.println("Quer mesmo remover o questionario "+ nome + "? y/n");
            String satisfeito= sc.nextLine();
            while(ciclo) {
                switch (satisfeito.toUpperCase()) {
                    case "Y":
                        System.out.println("Questionario removido!");
                        return satisfeito.toUpperCase();
                    case "N":
                        System.out.println("Questionaro nao removido!");
                        return satisfeito.toUpperCase();
                    default:
                        System.out.println("Insira y/n!");
                        satisfeito= sc.nextLine();
                        break;
                }
            }
            return satisfeito.toUpperCase();
    }

    private static void apagarQuestionario(ListaQuestionariosn obj) throws RemoteException {
        Scanner sc = new Scanner(System.in);
        int tamanho= obj.returnContador();
        if(tamanho==0) {
            System.out.println("Nao existem questionarios guardados!");
        } else {
            System.out.println("Qual é o numero do questionario que quer apagar?");
            int valor = scan(sc, 1, tamanho);
            String result = obj.returnQuestionarioNome(valor);
            String remover = removerConfirm(sc, result);
            if("Y".equals(remover))
                obj.removeQuestionario(valor);
        }
    }

    private static void logoutAdmin() {
        isIt = "Client";
        System.out.println("Tem agora privilegios basicos de cliente.");
    }

    private static void exitProgram() {
        System.out.println("Adeus");
        System.exit(0);
    }

    public static void mainMenu(ListaQuestionariosn obj) throws RemoteException {

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

                    responderQuestionarios(obj);

            } else if(sc.toUpperCase().equals("CRIAR") && isIt.equals("Admin")) {
                    //criar um questionario com permissao de admin

                    criarQuestionario(obj);

            } else if(sc.toUpperCase().equals("VER") ){

                    verQuestoesQuestionario(obj);

            }else if(sc.toUpperCase().equals("MEDIA") ){

                        verMediaQuestionario(obj);

            }else if(sc.toUpperCase().equals("VEZES") ){

                        verVezesQuestionario(obj);

            }else if(sc.toUpperCase().equals("APAGAR") && isIt.equals("Admin")) {

                    apagarQuestionario(obj);

            } else if(sc.toUpperCase().equals("LOGOUT") && isIt.equals("Admin")) {
                    //fazer logout de admin e voltar a cliente

                    logoutAdmin();

            } else if(sc.toUpperCase().equals("EXIT")) {
                    //sair do programa

                    exitProgram();

            } else {
                System.out.println("Comando nao reconhecido...");
            }
        }
    }
        


    public static void main(String args[]) {
	String regHost = "localhost";
	String regPort = "9000";  // porto do binder
	String frase= "";

	if (args.length !=2) { // requer 2 argumentos
	    System.out.println
		("Usage: java so2.MenuClient registryHost registryPort");
	    System.exit(1);
	}
	regHost= args[0];
	regPort= args[1];
        
        try {
            ListaQuestionariosn obj =
            (ListaQuestionariosn) java.rmi.Naming.lookup("rmi://" + regHost + ":" + 
                                          regPort + "/quest");
            

            mainMenu(obj);
        
        } catch(NotBoundException | MalformedURLException | RemoteException  e) {
            System.err.println("Oops! Something went wrong!");
        }
    }
}
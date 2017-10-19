package so2;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class MenuClient {
    
    static String password = "1234";
    static String isIt;
    
    /**
     * Recebe um scanner e recebe a password do utilizador
     * consoante essa password, muda o cliente para admin ou nao
     * 
     * @param sc 
     */
    private static void toAdmin(Scanner sc) {
        System.out.println("Insira a password:");
        String s = sc.nextLine();
        if(s.equals(password)){
            isIt = "Admin";
            System.out.println("Tem agora privilegios de Admin.");
        } else
            System.out.println("Password Errada!");
    }
    
    /**
     * Lista todos os comandos possiveis
     * Para Cliente e Admin respectivamente
     */
    private static void listarComandos() {
        System.out.println("Comandos possiveis:\n'listar'\n'responder'\n'ver'\n'media'\n'vezes'");
        if(isIt.equals("Client"))
            System.out.println("'admin'");
        else if(isIt.equals("Admin"))
            System.out.println("'criar'\n'apagar'\n'logout'");
        System.out.println("'exit'");
    }
    
    /**
     * 
     * Recebe o objecto remoto e utiliza os metodos para fazer print
     * a uma String que mostra todos os questionarios na Base de Dados
     * 
     * @param obj
     * @throws RemoteException 
     */
    private static void listarQuestionarios(OperacoesDB obj) throws RemoteException {
        int tamanho= obj.returnContador();
        if(tamanho==0)
            System.out.println("Nao existem questionarios guardados!");
        else {
            String listar = obj.listarQuestionarios();
            System.out.println(listar);
        }
    }
    
    /**
     * 
     * Recebe o objecto remoto e utiliza os metodos para responder
     * a todas as perguntas de uma questao
     * 
     * @param obj
     * @throws RemoteException 
     */
    private static void responderQuestionarios(OperacoesDB obj) throws RemoteException {
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
    
    /**
     * 
     * Recebe o objecto remoto e utiliza os metodos para
     * fazer print a uma String que contem todas questoes de
     * um determinado questionario
     * 
     * @param obj
     * @throws RemoteException 
     */
    private static void verQuestoesQuestionario(OperacoesDB obj) throws RemoteException {
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
    
    /**
     * Recebe um objecto remoto e utiliza os metodos para
     * fazer print a uma String com as medias das perguntas
     * de uma determinada questao
     * 
     * @param obj
     * @throws RemoteException 
     */
    private static void verMediaQuestionario(OperacoesDB obj) throws RemoteException {
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
    
    /**
     * 
     * Recebe um objecto remoto e utiliza os metodos para
     * fazer print de uma String que contem as vezes que um
     * certo questionario foi respondido
     * 
     * @param obj
     * @throws RemoteException 
     */
    private static void verVezesQuestionario(OperacoesDB obj) throws RemoteException {
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
    
    /**
     * 
     * Recebe um objecto remoto e utiliza os metodos para
     * criar um questionario e adiciona-lo a Base de Dados
     * 
     * @param obj
     * @throws RemoteException 
     */
    private static void criarQuestionario(OperacoesDB obj) throws RemoteException {
        
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
    
    /**
     * 
     * Recebe um Scanner e dois inteiros e fica em ciclo ate a resposta
     * recebida por input estar entre os valores inteiros 'start e 'end'
     * Retorna por fim o input do utilizador
     * 
     * @param sc
     * @param start
     * @param end
     * @return 
     */
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
    
    /**
     * 
     * Recebe um Scanner e uma String e entra em loop ate 
     * o utilizador responder afirmativo ou negativo.
     * 
     * @param sc
     * @param nome
     * @return 
     */
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
    
    /**
     * 
     * Recebe um objecto remoto e utiliza os metodos para
     * apagar o questionario pretendido da Base de Dados
     * 
     * @param obj
     * @throws RemoteException 
     */
    private static void apagarQuestionario(OperacoesDB obj) throws RemoteException {
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
    
    /**
     * Faz o utilizador ter permissoes basicas de cliente
     */
    private static void logoutAdmin() {
        isIt = "Client";
        System.out.println("Tem agora privilegios basicos de cliente.");
    }

    /**
     * Sai do programa com exito
     */
    private static void exitProgram() {
        System.out.println("Adeus.");
        System.exit(0);
    }

    /**
     * Metodo principal onde todos os outros metodos
     * da classe sao chamados de acordo com input do utilizador
     * 
     * @param obj
     * @throws RemoteException 
     */
    public static void mainMenu(OperacoesDB obj) throws RemoteException {

        isIt = "Client";
        System.out.println("Bem vindo a plataforma de Questionarios!\n"
            + "Encontra-se neste momento no Menu.\n"
            + "(Para saber os comandos escreva 'help')");
        Scanner scanner = new Scanner(System.in);
        String sc;
        while(true) {
            sc = scanner.nextLine();
            System.out.println();
            if(sc.toUpperCase().equals("ADMIN") && isIt.equals("Client")) {

                toAdmin(scanner);
                
                System.out.println("\nDe volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");

            } else if(sc.toUpperCase().equals("HELP")) {
                
                listarComandos();
                
                System.out.println("\nDe volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");

            } else if(sc.toUpperCase().equals("LISTAR")) {

                listarQuestionarios(obj);
                
                System.out.println("De volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");

            } else if(sc.toUpperCase().equals("RESPONDER")) {
                
                responderQuestionarios(obj);
                
                System.out.println("\nDe volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");

            } else if(sc.toUpperCase().equals("CRIAR") && isIt.equals("Admin")) {

                criarQuestionario(obj);
                
                System.out.println("\nDe volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");

            } else if(sc.toUpperCase().equals("VER")) {

                verQuestoesQuestionario(obj);
                
                System.out.println("De volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");

            }else if(sc.toUpperCase().equals("MEDIA")) {

                verMediaQuestionario(obj);
                
                System.out.println("De volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");

            }else if(sc.toUpperCase().equals("VEZES")) {

                verVezesQuestionario(obj);
                
                System.out.println("\nDe volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");

            }else if(sc.toUpperCase().equals("APAGAR") && isIt.equals("Admin")) {
                
                apagarQuestionario(obj);
                
                System.out.println("\nDe volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");

            } else if(sc.toUpperCase().equals("LOGOUT") && isIt.equals("Admin")) {
                
                logoutAdmin();
                
                System.out.println("\nDe volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");

            } else if(sc.toUpperCase().equals("EXIT")) {
                
                exitProgram();

            } else {
                System.out.println("Comando nao reconhecido...\n");
                
                System.out.println("De volta ao menu.\n"
            + "(Para saber os comandos escreva 'help')");
            }
        }
    }
        

    public static void main(String args[]) {
	String regHost = "localhost";
	String regPort = "9000";  // porto do binder

	if (args.length != 2) { // requer 2 argumentos
	    System.out.println
		("Usage: java so2.MenuClient registryHost registryPort");
	    System.exit(1);
	}
	regHost= args[0];
	regPort= args[1];
        
        try {
            OperacoesDB obj =
            (OperacoesDB) java.rmi.Naming.lookup("rmi://" + regHost + ":" + 
                                          regPort + "/quest");
            

            mainMenu(obj);
        
        } catch(NotBoundException  e) {
            System.err.println("Oops! Object not bound!");
        } catch(MalformedURLException e) {
            System.out.println("Oops! Malformed URL Exception!");
        } catch(RemoteException e) {
            System.out.println("Oops! RMI Remote Exception!");
        }
    }
}
package so2;

import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class MainMenuImpl extends UnicastRemoteObject implements MainMenu, java.io.Serializable{
	static String password = "1234";
        static String isIt;
        ListaQuestionarios lista = new ListaQuestionarios();
        
        
        // deve existir um construtor
        public MainMenuImpl() throws java.rmi.RemoteException {
            super();
        }

	public void toAdmin(String pass) throws java.rmi.RemoteException{
		if(pass.equals(password)){
			isIt = "Admin";
			System.out.println("Tem agora privilegios de Admin.");

		} else
			System.out.println("Password Errada!");
	}

	public void listarComandos() throws java.rmi.RemoteException {
		System.out.println("Comandos possiveis:\n'listar'\n'responder'");
		if(isIt.equals("Client"))
			System.out.println("'admin'");
		else if(isIt.equals("Admin"))
			System.out.println("'criar'\n'apagar'\n'logout'");
		System.out.println("'exit'");
	}

	public void listarQuestionarios() throws java.rmi.RemoteException{
		//to do
	}

	public void responderQuestionarios() throws java.rmi.RemoteException{
		//to do
	}

	public void criarQuestionario() throws java.rmi.RemoteException{
		//to do
	}

	public void apagarQuestionario() throws java.rmi.RemoteException{
		//to do
	}

	public void logoutAdmin() throws java.rmi.RemoteException{
		isIt = "Admin";
		System.out.println("Tem agora privilegios basicos de cliente.");
	}

	public void exitProgram() throws java.rmi.RemoteException{
		System.exit(0);
	}
        
	public void menu() throws java.rmi.RemoteException{
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

				System.out.println("Insira a password:");
				sc = scanner.nextLine();
				this.toAdmin(sc);

			} else if(sc.toUpperCase().equals("HELP")) {
				//listar todos os comandos possiveis

				this.listarComandos();

			} else if(sc.toUpperCase().equals("LISTAR")) {
				//listar os questionarios disponiveis

				this.listarQuestionarios();

			} else if(sc.toUpperCase().equals("RESPONDER")) {
				//responder aos questionarios

				this.responderQuestionarios();

			} else if(sc.toUpperCase().equals("CRIAR") && isIt.equals("Admin")) {
				//criar um questionario com permissao de admin

				this.criarQuestionario();

			} else if(sc.toUpperCase().equals("APAGAR") && isIt.equals("Admin")) {
				//apagar um questionario com permissao de admin

				this.apagarQuestionario();

			} else if(sc.toUpperCase().equals("LOGOUT") && isIt.equals("Admin")) {
				//fazer logout de admin e voltar a cliente

				this.logoutAdmin();

			} else if(sc.toUpperCase().equals("EXIT")) {
				//sair do programa

				this.exitProgram();

			} else {
                            System.out.println("Comando não reconhecido...");
                        }
		}
	}
        
        
}
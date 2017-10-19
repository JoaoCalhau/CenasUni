import java.util.Scanner;

public class MainMenu {
	static String password = "1234";
        static String isIt;

	private static void toAdmin(String pass) {
		if(pass.equals(password)){
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

	private static void listarQuestionarios() {
		//to do
	}

	private static void responderQuestionarios() {
		//to do
	}

	private static void criarQuestionario() {
		//to do
	}

	private static void apagarQuestionario() {
		//to do
	}

	private static void logoutAdmin() {
		isIt = "Admin";
		System.out.println("Tem agora privilegios basicos de cliente.");
	}

	private static void exitProgram() {
		System.exit(0);
	}
        
	public static void menu() {
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
				toAdmin(sc);

			} else if(sc.toUpperCase().equals("HELP")) {
				//listar todos os comandos possiveis

				listarComandos();

			} else if(sc.toUpperCase().equals("LISTAR")) {
				//listar os questionarios disponiveis

				listarQuestionarios();

			} else if(sc.toUpperCase().equals("RESPONDER")) {
				//responder aos questionarios

				responderQuestionarios();

			} else if(sc.toUpperCase().equals("CRIAR") && isIt.equals("Admin")) {
				//criar um questionario com permissao de admin

				criarQuestionario();

			} else if(sc.toUpperCase().equals("APAGAR") && isIt.equals("Admin")) {
				//apagar um questionario com permissao de admin

				apagarQuestionario();

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
        
        public static void main(String[] args) {
            menu();
        }
}
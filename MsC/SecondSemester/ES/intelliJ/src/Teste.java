public class Teste {

    private String teste;

    public Teste() {
        teste = "Teste";
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public String getTeste() {
        return this.teste;
    }

    public static void main(String[] args) {
        Teste teste = new Teste();

        System.out.println(teste.getTeste());

        teste.setTeste("Testinho");

        System.out.println(teste.getTeste());
    }
}

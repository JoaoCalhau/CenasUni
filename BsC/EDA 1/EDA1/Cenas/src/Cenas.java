public class Cenas {
    public String cenas() {
        return "Cenas";
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] cenas = new int[10];
        int i = 0;
        while (i < cenas.length) {
            cenas[i] = i;
            System.out.println(cenas[i]);
            ++i;
        }

        int x = 0;

        if (x == 0) {
            System.out.println("Es puta");
        } else if (x == 10) {
            System.out.println("Nem sei o que es...");
        } else {
            System.out.println("Nao es puta");
        }

        System.out.println(x += 10);

        String s = "Cenas";
        System.out.println(s);

        Picha picha = new Picha();
        System.out.println(picha.picha());
    }
}

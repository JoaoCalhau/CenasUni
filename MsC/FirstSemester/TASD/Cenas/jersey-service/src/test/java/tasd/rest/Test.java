package tasd.rest;

public class Test {
    public static void main(String[] args) {
        NewJerseyClientLast client = new NewJerseyClientLast();
        NewJerseyClientAll client2 = new NewJerseyClientAll();
        
        client.putCustomer("JDoe", "John", "Doe");
        client.putCustomer("Uluthr3k", "João", "Calhau");
        client.putCustomer("Flor", "Florbela", "Espanca");
        
        
        String str = client2.getAllCustomers("".getClass());
        
        String[] arr = str.split(",");
        for (String s : arr) {
            System.out.println(s.split("=")[1]);
        }
    }
}

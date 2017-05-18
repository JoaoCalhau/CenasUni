package scad;

public class Examples {
    public static void main(String[] args) {
        int b1 = -1001;
        int b2 = -1002;
        double sol1, sol2;
        int B = 1002;
        
        sol1 = Math.log(Math.exp(b1) + Math.exp(b2));
        
        System.out.println("Solution 1: " + sol1);
        
        sol2 = Math.log(Math.exp(b1+B) + Math.exp(b2+B)) - B;
        
        System.out.println("Solution 2: " + sol2);
        
    }
}

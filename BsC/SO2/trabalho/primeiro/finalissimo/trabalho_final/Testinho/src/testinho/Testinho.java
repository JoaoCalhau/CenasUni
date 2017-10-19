
package testinho;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Testinho {
    
    ArrayList<Integer> lista;
    boolean exists;
    
    public void writeQuest() {
        try {
            FileOutputStream fos = new FileOutputStream("Data.file");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            
        } catch (Exception e) {
            System.err.println("Oops! Something went wrong while saving file!");
        }
    }
    
    public void loadQuest() {
        try {
            FileInputStream fis = new FileInputStream("Data.file");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = new ArrayList<>((ArrayList<Integer>) ois.readObject());
            exists = true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Oops! Something went wrong while loading the file!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            while(scanner.hasNext()) {
                int num = scanner.nextInt();
                if(num < 1) {
                    throw new Exception("conta");
                }
                System.out.println(num + " fixe.");
            }
        } catch(InputMismatchException e) {
                System.out.println("nao pesca.");
        } catch(Exception e) {
                   System.out.println("nao " + e.getMessage()); 
        } finally {
                    System.out.println("pois.");
        }
    }
}

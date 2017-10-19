/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pimenta
 */

import java.util.ArrayList;
import java.util.Scanner;


public class ListaQuestionarios {
    
    ArrayList<Questionario> lista;
    int contador;
    
    
    public ListaQuestionarios(){
        lista = new ArrayList<Questionario>();
        contador=0;
    }
    
    public void addQuestionario(){
        Scanner sc = new Scanner(System.in);
        int quantidade = 0;
        while(quantidade>5 || quantidade <3){
            System.out.println("Insira valor válido: Entre 3 e 5 inclusive\n");
            try{
                quantidade = sc.nextInt();
            }
            catch(Exception e){
                System.out.println("Insira um Int válido entre 3 e 5\n");
                continue;
            }
        }
        Questionario novo = new Questionario(quantidade, ++contador);
        lista.add(novo);
        
    }
    
    public void respondeQuestionario(int numQuestionario) {
        int pos = numQuestionario-1;
        if(pos> lista.size()){
            System.out.println("Fora do Range");
        }
        else{
            lista.get(pos).responderPerguntas();
        }
        
    }
    
    
}

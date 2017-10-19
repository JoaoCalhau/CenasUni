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

public class Pergunta {
    
    String questao;
    ArrayList<Integer> resposta;
    
    
    public Pergunta(String pergunta){
        this.questao = pergunta;
        resposta = new ArrayList<Integer>();
        
    }
    
    public void Responder(int valor){
        this.resposta.add(valor);
        
    }
    
    public String toString(){
        return this.questao;
    }
    
}

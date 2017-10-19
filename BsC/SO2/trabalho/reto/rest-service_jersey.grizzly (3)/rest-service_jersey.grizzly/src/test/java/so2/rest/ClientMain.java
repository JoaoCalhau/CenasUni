/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so2.rest;

import java.util.ArrayList;
import so2.rest.*;
/**
 *
 * @author Daniel Reto
 */
public class ClientMain {
    public static void main (String [] args){
        
        NewJerseyClient n = new NewJerseyClient();
        Pergunta p1 = new Pergunta("Cenas?");
        Pergunta p2 = new Pergunta("Mais Cenas?");
        Pergunta p3 = new Pergunta("Bue Cenas?");
        Pergunta p4 = new Pergunta("Ainda mais Cenas?");
        Pergunta p5 = new Pergunta("Coisas?");
        Pergunta p6 = new Pergunta("Mais coisas?");
        ArrayList<Pergunta> l1 = new ArrayList();
        ArrayList<Pergunta> l2 = new ArrayList();
        l1.add(p1);
        l1.add(p2);
        l1.add(p3);
        l1.add(p4);
        l2.add(p4);
        l2.add(p5);
        l2.add(p6);
        
        ListQuest l = new ListQuest();
        l = n.getQuestList_JSON(l.getClass());
        
        Questionarios q1 = new Questionarios("cenas3",l1);
        Questionarios q2 = new Questionarios("cenas4",l2);
        n.putQuestList_JSON(q1,"0");
        n.putQuestList_JSON(q2,"0");
        l = new ListQuest();
        l = n.getQuestList_JSON(l.getClass());
        
        /*
        
        n.deleteQuestList("1");
        
        l = n.getQuestList_JSON(l.getClass());
        
        */
        
        
    }
}

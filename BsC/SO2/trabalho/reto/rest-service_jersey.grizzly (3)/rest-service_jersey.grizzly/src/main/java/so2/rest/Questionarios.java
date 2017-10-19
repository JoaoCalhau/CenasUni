package so2.rest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "questionarios")
public class Questionarios {
    
    @XmlElement(required = true)
    protected int numQuest;
    @XmlElement(required = true)
    protected String nomeQuest;         // nome do questionario
    @XmlElement(required = true)
    protected ArrayList<Pergunta> perg; // lista de perguntas que existem no questionario
    
    public Questionarios(){
        
    }
    
    public Questionarios(String nomeQuest, ArrayList<Pergunta> p) {
        this.numQuest = 0;
        this.nomeQuest = nomeQuest;
    	perg = p;
    }	

    // retorna o nome do questionario
    public String getNomeQuest(){
        return nomeQuest;
    }
    
    // altera o nome do questionario
    public void setNomeQuest(String nomeQuest){
        this.nomeQuest = nomeQuest;
    }
   
    // i = numero da pergunta, e retorna a pergunta numero i
    public String getPergunta(int i){
        return perg.get(i).getPerg();
    }
    
    // retorna uma string com todas as perguntas do questionario
    public ArrayList<Pergunta> getPerguntas(){
        return perg;
    }
    
    // adicionar uma pergunta a um questionario
    public void setPergunta(Pergunta p, int pos){
        perg.add(pos,p);
    }
    
    public void setPergunta(ArrayList<Pergunta> p){
        this.perg = p;
    }
   
    // adicionar todas as respostas de um questionario
    public void addResposta(int resp[]){
        int i = 0;
        for(Pergunta p : perg){
            p.resposta += resp[i];
            i++;
        }
    }
    
    public int getNumQuest(){
        return numQuest;
    }
    
    public void setNumQUest(int numQuest){
        this.numQuest = numQuest;
    }
}
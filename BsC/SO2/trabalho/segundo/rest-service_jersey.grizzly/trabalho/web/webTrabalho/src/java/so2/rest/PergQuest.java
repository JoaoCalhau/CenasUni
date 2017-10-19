package so2.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pergquest", propOrder = {
    "nome",
    "respostas",
    "total"
})

@XmlRootElement(name = "pergquest")
public class PergQuest {
    
    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    protected int respostas;
    @XmlElement(required = true)
    protected int total;
    
    public PergQuest() {
    }
    
    public PergQuest(String nome) {
        this.nome = nome;
        this.respostas = 0;
        this.total = 0;
    }
    
    public int getRespostas() {
        return this.respostas;
    }
    
    public void setResposta(int r) {
        this.respostas = r;
    }
    
    public void addResposta(int r) {
        this.respostas += r;
        this.total++;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int t) {
        this.total = t;
    }
    
    public void incTotal() {
        this.total++;
    }
}

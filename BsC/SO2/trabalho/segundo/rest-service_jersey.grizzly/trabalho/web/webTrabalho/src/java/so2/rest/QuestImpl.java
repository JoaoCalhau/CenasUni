package so2.rest;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
    
@XmlRootElement(name = "quest")
public class  QuestImpl {
    
    @XmlElement(required = true)
    protected List<PergQuest> perguntas;
    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    protected int numQ;
    @XmlElement(required = true)
    protected int maxSize;
    
    public QuestImpl() {
    }
    
    public QuestImpl(String nome) {
        this.perguntas = new LinkedList<>();
        this.nome = nome;
        this.numQ = 0;
        this.maxSize = 0;
    }
    
    public void addPergunta(String nome) {
        this.perguntas.add(new PergQuest(nome));
    } 
    
    public int size() {
        return this.perguntas.size();
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getNumQ() {
        return this.numQ;
    }
    
    public void setNumQ(int n) {
        this.numQ = n;
    }
    
    public int getMaxSize() {
        return this.maxSize;
    }
    
    public void setMaxSize(int s) {
        this.maxSize = s;
    }
    
    public List<PergQuest> getPerg() {
        return this.perguntas;
    }
    
    public void setPerg(List<PergQuest> l) {
        this.perguntas = l;
    }
    
    public void addPergunta(int index, int r) {
        this.perguntas.get(index).addResposta(r);
    }
}

package so2.rest;

import java.util.ArrayList;
import java.util.Formatter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pergunta", propOrder = {
    "perg",
    "resposta",
    "count"
})
@XmlRootElement(name = "pergunta")
public class Pergunta {

    @XmlElement(required = true)
    protected String perg;
    @XmlElement(required = true)
    protected int resposta;             // somatorio das respostas
    @XmlElement(required = true)
    protected int count;                // conbtador do numero de vezes que um questionario foi respondido

    public Pergunta(){
        
    }
    
    public Pergunta(String perg) {
	this.perg = perg;
	this.resposta = 0;
        this.count = 0;
    }
  
    public String getPerg() {
        return this.perg;
    }
    
    public void setPerg(String perg) {
        this.perg = perg;
    }
    
    public int getResposta() {
        return resposta;
    }
    
    public void setResposta(int resp) {
        this.resposta = resp;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setCount(int count){
        this.count = count;
    }

    public double media(){
        return (double)resposta/(double)count;
    }
    
    public void addResposta(int resposta){
        this.resposta += resposta;
        count++;
    }
}

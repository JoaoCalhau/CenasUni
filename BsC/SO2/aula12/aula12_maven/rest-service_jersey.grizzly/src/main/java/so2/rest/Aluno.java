package so2.rest;

import java.util.Formatter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aluno", propOrder = {
    "numero",
    "nome"
})
@XmlRootElement(name = "aluno")
public class Aluno {

    @XmlElement(required = true)
    protected int numero;
    @XmlElement(required = true)
    protected String nome;
   
    public Aluno() {
    }

    public Aluno(int numero, String nome) {
	this.numero= numero;
	this.nome= nome;
    }
  
    public String getNome() {
        return nome;
    }
    public int getNumero() {
        return numero;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}

package so2.rest;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "turma")
public class Turma {

    @XmlElement(required = true)
    protected List<Aluno> alunos;


    public Turma() {
    	alunos = new LinkedList<Aluno>();
    }	

   
    public List<Aluno> getAlunos() {
        return this.alunos;
    }
    

    protected void add( Aluno a ) {
	alunos.add( a );
    }

    protected int size() {
	return alunos.size();
    }
    
    public List<Aluno> getAlunosWithS(String s) {
        List<Aluno> cenas = new LinkedList<Aluno>();
        
        for(Aluno a : alunos) {
            if(a.getNome().toLowerCase().contains(s.toLowerCase()))
                cenas.add(a);
        }
        return cenas; 
    }
    
    public int countAlunosWithS(String s) {
        int count = 0;
        
        for(Aluno a : alunos) {
            if(a.getNome().toLowerCase().contains(s.toLowerCase()))
                count++;
        }
        return count;
    }
    
    public boolean checkAlunoNome(String n) {
        for(Aluno a : alunos) {
            if(a.getNome().equals(n))
                return true;
        }
        return false;
    }

}

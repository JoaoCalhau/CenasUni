package so2.rest;

import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaquest", propOrder = {
    "list"
})
@XmlRootElement(name = "listaquest")
public class ListaQuest {
    @XmlElement(required = true)
    List<QuestImpl> list;
    
    public ListaQuest() {
        this.list = new ArrayList<>();
    }
    
    public ListaQuest(List<QuestImpl> l) {
        this.list = l; 
    }
    public List<QuestImpl> getLista() {
        return this.list;
    }
    
    public void setList(List<QuestImpl> l) {
        this.list = l;
    }
}

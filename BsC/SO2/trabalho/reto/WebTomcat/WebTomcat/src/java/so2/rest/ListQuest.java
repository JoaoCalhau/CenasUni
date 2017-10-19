package so2.rest;

import java.util.ArrayList;
import java.util.Formatter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listquest", propOrder = {
    "cenas"
})
@XmlRootElement(name = "listquest")
public class ListQuest {

    @XmlElement(required = true)
    protected ArrayList<Questionarios> cenas;
   
    public ListQuest() {
        cenas = new ArrayList<>();
    }

    public ListQuest(ArrayList<Questionarios> quest) {
	cenas = quest;
    }
  
    public ArrayList<Questionarios> getListQuest() {
        return cenas;
    }

    public void setListQuest(ArrayList<Questionarios> q) {
        cenas = q;
    }
}

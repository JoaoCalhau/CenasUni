package tasd.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "names", propOrder = {
    "uniqueId",
    "first",
    "last"
})

@XmlRootElement(name = "names")
public class Names {
    
    @XmlElement(required = true)
    protected String uniqueId;
    @XmlElement(required = true)
    protected String first;
    @XmlElement(required = true)
    protected String last;
  
    
    public Names() {
        this.uniqueId = null;
        this.first = null;
        this.last = null;
    }
    
    public Names(String uniqueId) {
        this.uniqueId = uniqueId;
        this.first = null;
        this.last = null;
    }
    
    public Names(String uniqueId, String first) {
        this.uniqueId = uniqueId;
        this.first = first;
        this.last = null;
    }
    
    public Names(String uniqueId, String first, String last) {
        this.first = first;
        this.last = last;
        this.uniqueId = uniqueId;
    }
    
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    
    public void setFirst(String first) {
        this.first = first;
    }
    
    public void setSecond(String last) {
        this.last = last;
    }
    
    public String getUniqueId() {
        return uniqueId;
    }
    
    public String getFirst() {
        return first;
    }
    
    public String getLast() {
        return last;
    }
    
    @Override
    public String toString() {
        return "(Unique ID: " + uniqueId + ", First Name: " + first + ", Last Name: " + last + ")";
    }
}

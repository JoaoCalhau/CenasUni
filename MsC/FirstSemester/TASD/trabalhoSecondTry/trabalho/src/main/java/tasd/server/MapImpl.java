package tasd.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "map")
public class MapImpl {
    
    @XmlElement(required = true)
    protected HashMap<String, Names> map;
    @XmlElement(required = true)
    protected int size;
    
    public MapImpl() {
        map = new HashMap<>();
        size = 0;
    }
    
    public void addName(Names name) {
        map.put(name.getUniqueId(), name);
        size++;
    }
    
    public String getName(String uniqueId) {
        Names name = new Names();
        if(map.containsKey(uniqueId))
            name = map.get(uniqueId);
        
        return name.toString();
    }
    
    public int getSize() {
        return size;
    }
}

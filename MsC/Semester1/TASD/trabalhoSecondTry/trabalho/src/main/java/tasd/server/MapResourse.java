package tasd.server;

import com.sun.jersey.spi.resource.Singleton;

import java.io.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Singleton
@Path(value = "/map")
public class MapResourse {
    
    private MapImpl map;
    
    public MapResourse() {
        readFromFile();
    }
    
    @GET
    @Produces({"application/json", "application/xml"})
    public synchronized String getTable() {
        StringBuilder sb = new StringBuilder();
        for(String key : map.map.keySet())
            sb.append(key).append("\n");
        System.err.println("GET");
        return sb.toString();
    }
    
    @POST
    @Produces({"application/xml"})
    @Consumes({"application/xml"})
    public synchronized String getName(@QueryParam("uniqueid") String uniqueId) {
        if(map.map.containsKey(uniqueId)) {
            System.err.println("POST");
            return map.map.get(uniqueId).toString();
        } else {
            System.err.println("POST");
            return new Names(null).toString();
        }
    }
   
    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public synchronized String putTable(@QueryParam("uniqueid") String uniqueId) {
        
        if(map.map.containsKey(uniqueId)) {
            System.err.println("POST");
            return "false";
        } else {
            Names name = new Names(uniqueId);
            map.map.put(uniqueId, name);
            writeToFile();
            System.err.println("POST");
            return "true";
        }
    }
    
    @PUT
    @Consumes({"application/xml"})
    public synchronized void putTable(@QueryParam("uniqueid") String uniqueId,
                                         @QueryParam("first") String first) {
        
        if(map.map.containsKey(uniqueId)) {
            Names name = (Names) map.map.remove(uniqueId);
            name.setFirst(first);
            map.map.put(uniqueId, name);
            System.err.println("PUT");
        } else {
            Names name = new Names(uniqueId, first);
            map.map.put(uniqueId, name);
            System.err.println("PUT");
        }
        writeToFile();
    }
    
    @PUT
    @Consumes({"application/json"})
    public synchronized void putTable(@QueryParam("uniqueid") String uniqueId,
                                         @QueryParam("first") String first,
                                         @QueryParam("last") String last) {
        
        if(map.map.containsKey(uniqueId)) {
            Names name = (Names) map.map.remove(uniqueId);
            name.setFirst(first);
            name.setSecond(last);
            map.map.put(uniqueId, name);
            System.err.println("PUT");
        } else {
            Names name = new Names(uniqueId, first, last);
            map.map.put(uniqueId, name);
            System.err.println("PUT");
        }
        writeToFile();
    }
    
    public void writeToFile() {
        try {
            File file = new File("hashmap");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(map);
            oos.flush();
            oos.close();
            fos.close();
        } catch(Exception e) {
            System.err.println("Something went wrong writting...");
        }
    }
    
    public void readFromFile() {
        try {
            File file = new File("hashmap");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            MapImpl map = (MapImpl) ois.readObject();
            if(map == null)
                map = new MapImpl();
            else
                this.map = map;
        } catch(IOException | ClassNotFoundException e) {
            this.map = new MapImpl();
            System.err.println("Something went wrong reading...");
        }
    }
}

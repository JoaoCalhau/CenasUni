package tasd.server;

import com.sun.jersey.spi.resource.Singleton;
import java.io.*;
import java.util.*;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Singleton
@Path(value = "/hashtable")
public class HashTableResourse {
    
    private HashMap<String, Object> table;
    
    public HashTableResourse() {
        readFromFile();
    }
    
    @GET
    @Produces({"application/json", "application/xml"})
    public synchronized String getTable() {
        StringBuilder sb = new StringBuilder();
        for(String key : table.keySet())
            sb.append(key).append("\n");
        System.err.println("GET");
        return sb.toString();
    }
    
    @POST
    @Produces({"application/xml"})
    public synchronized String getName(@QueryParam("uniqueid") String uniqueId) {
        if(table.containsKey(uniqueId)) {
            System.err.println("POST");
            return table.get(uniqueId).toString();
        } else {
            System.err.println("POST");
            return new Names(null).toString();
        }
    }
   
    @POST
    @Produces({"application/json"})
    public synchronized String putTable(@QueryParam("uniqueid") String uniqueId) {
        
        if(table.containsKey(uniqueId)) {
            System.err.println("POST");
            return "false";
        } else {
            Names name = new Names(uniqueId);
            table.put(uniqueId, name);
            writeToFile();
            System.err.println("POST");
            return "true";
        }
    }
    
    @PUT
    @Produces({"application/xml"})
    public synchronized void putTable(@QueryParam("uniqueid") String uniqueId,
                                         @QueryParam("first") String first) {
        
        if(table.containsKey(uniqueId)) {
            Names name = (Names) table.remove(uniqueId);
            name.setFirst(first);
            table.put(uniqueId, name);
            System.err.println("PUT");
        } else {
            Names name = new Names(uniqueId, first);
            table.put(uniqueId, name);
            System.err.println("PUT");
        }
        writeToFile();
    }
    
    @PUT
    @Produces({"application/json"})
    public synchronized void putTable(@QueryParam("uniqueid") String uniqueId,
                                         @QueryParam("first") String first,
                                         @QueryParam("last") String last) {
        
        if(table.containsKey(uniqueId)) {
            Names name = (Names) table.remove(uniqueId);
            name.setFirst(first);
            name.setSecond(last);
            table.put(uniqueId, name);
            System.err.println("PUT");
        } else {
            Names name = new Names(uniqueId, first, last);
            table.put(uniqueId, name);
            System.err.println("PUT");
        }
        writeToFile();
    }
    
    public void writeToFile() {
        try {
            File file = new File("hashmap");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(table);
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
            HashMap<String, Object> map = (HashMap<String, Object>) ois.readObject();
            if(map == null)
                table = new HashMap();
            else
                table = map;
        } catch(IOException | ClassNotFoundException e) {
            table = new HashMap();
            System.err.println("Something went wrong reading...");
        }
    }
}

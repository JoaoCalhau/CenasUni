package tasd.rest;

import java.util.HashMap;

public class CustomerImpl {
    
    private HashMap<String, Object> map;
    
    public CustomerImpl() {
        map = new HashMap<>();
    }
    
    public Customer getCustomer(String uniqueID) {
        if(map.containsKey(uniqueID))
            return (Customer)map.get(uniqueID);
        else
            return new Customer();
    }
    
    public HashMap getMap() {
        return map;
    }
    
    public String addMap(String uniqueID) {
        if(map.containsKey(uniqueID)) {
            return "false";
        } else {
            Customer c = new Customer(uniqueID);
            map.put(uniqueID, c);
            return "true";
        }
    }
    
    public void addMap(String uniqueID, String firstName) {
        if(map.containsKey(uniqueID)) {
            Customer c = (Customer) map.remove(uniqueID);
            c.setFirstName(firstName);
            map.put(uniqueID, c);
        } else {
            Customer c = new Customer(uniqueID, firstName);
            map.put(uniqueID, c);

        }
    }
    
    public void addMap(String uniqueID, String firstName, String lastName) {
        if(map.containsKey(uniqueID)) {
            Customer c = (Customer)map.remove(uniqueID);
            c.setFirstName(firstName);
            c.setLastName(lastName);
            map.put(uniqueID, c);

        } else {
            Customer c = new Customer(uniqueID, firstName, lastName);
            map.put(uniqueID, c);

        }
    }
    
}

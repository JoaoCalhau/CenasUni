package tasd.rest;

public class Customer {
    private final String uniqueID;
    private String firstName;
    private String lastName;
    
    public Customer() {
        uniqueID = null;
        firstName = null;
        lastName = null;
    }
    
    public Customer(String uniqueID) {
        this.uniqueID = uniqueID;
        this.firstName = null;
        this.lastName = null;
    }
    
    public Customer(String uniqueID, String firstName) {
        this.uniqueID = uniqueID;
        this.firstName = firstName;
        this.lastName = null;
    }
    
    public Customer(String uniqueID, String firstName, String lastName) {
        this.uniqueID = uniqueID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getUniqueID() {
        return this.uniqueID;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        if(uniqueID == null) {
            return "";
        } else if(firstName == null) {
            return "UniqueID: " + uniqueID;
        } else if(lastName == null) {
            return "UniqueID: " + uniqueID + "\n\tFirst Name: " + firstName;
        } else {
            return "UniqueID: " + uniqueID + "\n\tFirst Name: " + firstName + "\n\tLast Name: " + lastName;
        }
    }
}

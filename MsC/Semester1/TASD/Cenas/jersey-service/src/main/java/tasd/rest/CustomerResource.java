package tasd.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/customers")
public class CustomerResource {
    
    CustomerImpl c;
    
    public CustomerResource() {
        c = new CustomerImpl();
        c.addMap("Uluthr3k", "João", "Calhau");
        c.addMap("JDoe", "John", "Doe");
        c.addMap("Flor", "Florbela", "Espanca");
    }
    
    @Path("/all")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllCustomers() {
        return c.getMap().toString();
    }
    
    @GET
    @Path("/one")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCustomer(@QueryParam("id") String id) {
        Customer cust = c.getCustomer(id);
        if(cust.getUniqueID() == null) {
            return "false";
        } else {
            return cust.toString();
        }
    }
    
    @PUT
    @Path("/newId")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putCustomer(@QueryParam("id") String id) {
        System.out.println(id);
        String response = c.addMap(id);
        System.err.println("PUT ID");
        System.err.println(response);
    }
    
    @PUT
    @Path("/newFirst")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putCustomer(@QueryParam("id") String id,
                            @QueryParam("first") String first) {
        c.addMap(id, first);
        System.err.println("PUT ID FIRST");
    }
    
    @PUT
    @Path("/newLast")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putCustomer(@QueryParam("id") String id,
                            @QueryParam("first") String first,
                            @QueryParam("last") String last) {
        c.addMap(id, first, last);
        System.err.println("PUT ID FIRST LAST");
    }
    
}

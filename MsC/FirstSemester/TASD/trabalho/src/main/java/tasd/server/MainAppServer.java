package tasd.server;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class MainAppServer {

    
    private static int getPort(int defaultPort) {
        return defaultPort;        
    } 
    
    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/tasd/").port(getPort(36764)).build();
    }

    public static final URI BASE_URI = getBaseURI();
   
    public static HttpServer startServer() throws IOException{
        ResourceConfig rc = new PackagesResourceConfig("tasd");
        return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println("Starting grizzly...");
        HttpServer httpServer = startServer();

        System.out.println("\n## Jersey app started with WADL available at "+BASE_URI+"application.wadl\n" +
                	   "-- Hit enter to stop it...");

        System.in.read();
        httpServer.stop();
    }    

}

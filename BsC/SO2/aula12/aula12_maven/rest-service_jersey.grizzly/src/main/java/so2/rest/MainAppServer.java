package so2.rest;

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
        return UriBuilder.fromUri("http://localhost/so2/").port(getPort(9200)).build();
    }

    public static final URI BASE_URI = getBaseURI();
   
    public static HttpServer startServer() throws IOException{
	// ativar um servico com os REST resources existentes neste pacote:
        ResourceConfig rc = new PackagesResourceConfig("so2.rest");
        return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println("Starting grizzly...");
        HttpServer httpServer = startServer();

	System.out.println("\n## Para um primeiro teste, veja isto no browser: "+BASE_URI+"turma");
        System.out.println("\n## Jersey app started with WADL available at "+BASE_URI+"application.wadl\n" +
                	   "-- Hit enter to stop it...");

        System.in.read();
	// depois do enter:
        httpServer.stop();
    }    

}

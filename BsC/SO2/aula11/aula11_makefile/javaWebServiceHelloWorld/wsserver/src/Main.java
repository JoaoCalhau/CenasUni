import javax.xml.ws.Endpoint;

public class Main {

	public static void main(String[] args) {
		// disponibilizar o Web Service
		// Requisito: JSE1.6
      		Endpoint.publish(
         		"http://localhost:7070/WebServiceSO2/myhello",
         		new so2.MyHelloImpl());
	}

}

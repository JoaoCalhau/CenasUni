import java.net.*;

public class Sockets {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("host.di.uevora.pt");
		System.out.println ("IP: " + inet.getHostAddress());
	}
}
public class MyWSClient {

    public static void main(String[] args) {
        try { 
	  /* Inicializar um Proxy para o Web Service
	     Note-se que estas classes foram geradas automaticamente (por wsimport).
	  */
             so2.MyHelloImplService service= new so2.MyHelloImplService();
             so2.MyHelloImpl port = service.getMyHelloImplPort();

	     // aceder 'a operacao hello() do Web Service
             String result = port.hello("James Brown");

             System.out.println("Resultado = "+result);

        } catch (Exception ex) {
		ex.printStackTrace();  
        }
    }
}


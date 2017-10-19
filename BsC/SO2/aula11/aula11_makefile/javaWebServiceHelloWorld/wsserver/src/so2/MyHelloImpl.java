package so2;

import javax.jws.WebService;
import javax.jws.WebMethod;


@WebService
public class MyHelloImpl {


   /* metodo com uma das operacoes do Web Service */	

   @WebMethod
   public String hello(String name) {
     return "\n --> Ola " + name + "! \n";
   }


}

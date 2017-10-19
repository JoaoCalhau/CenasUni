import java.io.*;
import java.util.StringTokenizer;

public class Prat2{

  public static void main(String[] args){
   
    System.out.println("Digite a expressao;");
    
    try {
      BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(bf.readLine(),"AaBb",true);
     // implementar o algoritmo
      while(st.hasMoreTokens()){
        System.out.println(st.nextToken());
      }
    }
    catch(IOException e) {}
  }
}
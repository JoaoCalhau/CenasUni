import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class My_Data {
  private int dia;
  private int mes;
  private int ano;
  
  public My_Data(){
    // data actual do computador
    GregorianCalendar c=new GregorianCalendar();
    c.setTime(new Date());
    dia=c.get(Calendar.DATE);
    mes=c.get(Calendar.MONTH)+1;
    ano=c.get(Calendar.YEAR);
  }
 
  private  int diasMes(int m, int a){
    switch (m){
      case 11:
      case 4:
      case 6:
      case 9: return 30;
      case 2:if (bissexto(a)) return 29;else return 28;
      default:return 31;
    }
  }
  private boolean bissexto(int a){
    return ((a%4==0)&& (a%100!=0)) || (a%400==0);
  }
  public My_Data(int d, int m, int a){
   
    if((a>=0) && (m >=1 && m <=12)){
      if ((d<=diasMes(m,a)) && (d>0)){
        dia=d;
        mes=m;
        ano=a;
      }
      else{
        dia=diasMes(m,a);
        mes=m;
        ano=a;
      }
    }
    
    else{
      dia=new My_Data().getDia();
      mes=new My_Data().getMes();
      ano=new My_Data().getAno();
    }
  }
      
  public int getDia(){
    return dia;
  }
  public int getMes(){
    return mes;
  }
  public int getAno(){
    return ano;
  }
  
  public static String mesToString(int mes){
     String mesSt="";
    switch (mes){
      case 1: mesSt="Jan";
      break;
      case 2: mesSt="Fev";
      break;
      case 3: mesSt="Mar";
      break;
      case 4: mesSt="Abr";
      break;
      case 5: mesSt="Mai";
      break;
      case 6: mesSt="Jun";
      break;
      case 7: mesSt="Jul";
      break;
      case 8: mesSt="Ago";
      break;
      case 9: mesSt="Set";
      break;
      case 10: mesSt="Out";
      break;
      case 11: mesSt="Nov";
      break;
      case 12: mesSt="Dez";
      break;
      default: mesSt="Error";
    }
    return mesSt;
  }
  public String toString(){
   
    return dia +"/"+mesToString(mes)+"/"+ano;
  }
  
  public Object clone(){
    return new My_Data(dia,mes,ano);
  }
  public My_Data  diaSeguinte(){
    int d=dia;
    int m=mes;
    int a=ano;
    if (dia==diasMes(mes,ano)){
      d=1;
      m=mes+1;
      //a=ano;
    }
    else{
      d=dia+1;
      //mes=m;
      //ano=a;
    }
    if (m==13){
      m=1;
      a=ano+1;
    }
    return new My_Data(d,m,a);
  }
  public void setDia(int d){
    if (d>=1 && d<=diasMes(mes,ano))
      dia=d;
  }
  
  public void add(int n){
    My_Data d=new My_Data(dia,mes,ano);
    for (int i=1;i<=n;i++)
      d=d.diaSeguinte();
    dia=d.dia;
    mes=d.mes;
    ano=d.ano;
  }
  
  public boolean maior(My_Data x){
    //retorna true se this maior x
      if(ano > x.ano)
        return true;
      if (ano==x.ano && mes>x.mes)
        return true;
      if (ano==x.ano && mes==x.mes && dia>x.dia)
        return true;
    return false;
  }
  
  
      
  public static void main(String[] args){
   My_Data d=new My_Data();
   System.out.println(d);
    
    
  }
}
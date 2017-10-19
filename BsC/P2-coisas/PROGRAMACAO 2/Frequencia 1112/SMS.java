public class SMS{
  private int remetente;
  private int destinatario;
  private String[] mensagens;
  private String texto;





  public SMS(int rem,int dest,String text){
     this.remetente=rem;
     this.destinatario=dest;
     if(text.length()>160){
          this.texto=text.substring(0,159);
        }
        else{
          this.texto=text;
        }
 
  }

  public int getDestinatario(){
     return this.destinatario;

  }

  public String getMensagem(){
     return this.texto;
  }






  public void setMensagem(String mess){
     if(mess.length()>160){
       this.texto=mess.substring(0,159);
     }
      else{ 
         this.texto=mess;
      }

  }



  public String toString(){
        return "De: "+ this.remetente + "\n" +
        "Para: " + this.destinatario + "\n" +
        this.texto;

  }


  public int size(){
    return (this.texto).length();
  
  }
  
  
  public boolean equals(Object x){
    if (this==x){
      return true;
    }
    if(x==null||(this.getClass()!=x.getClass())){
      return false;
    }
    SMS sms1=(SMS)x;
    return this.remetente==sms1.remetente && 
      this.destinatario==sms1.destinatario && 
      this.texto==sms1.texto;
  
  }
  
  public SMS clone(){
    return new SMS(this.remetente,this.destinatario,this.texto);
  
  }
  
    
  


}

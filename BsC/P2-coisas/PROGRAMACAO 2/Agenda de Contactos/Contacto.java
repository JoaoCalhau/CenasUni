import java.util.ArrayList;
import java.util.Iterator;



public class Contacto {
  
 String nome;
 ArrayList<Integer> telefones = new ArrayList<Integer> ();
 
 
 public Contacto(String nome,Integer telefone){
   this.nome=nome;
   this.telefones.add(telefone);
 }
 
 public Contacto(String nome, ArrayList<Integer> lista){
   this.nome=nome;
   //this.telefones.addAll(lista);
   this.telefones=lista;
 }
 
 public void setNome(String nome){
   this.nome=nome;
 }
 
 public String getNome(String nome){
   return this.nome;
 }
 
 public void addTelefone(Integer t){
   this.telefones.add(0,t);
 }
 
 public void alterarTelefone(Integer t, Integer tn){
   //Collections.replaceAll(telefones, t,tn);
   if(telefones.contains(t)){
     int index=telefones.indexOf(t);
     //telefones[index]=tn;
     telefones.set(index, tn);
   }
   else{
     System.out.println("Número não existe");
   }
  }
  
 
 public String numerosTelefone(){
    String s="("; 
    Iterator<Integer> it=telefones.iterator();
    while (it.hasNext()){
      s+=Integer.toString(it.next())+ " ;";
    }
    return s + ")";
  }

 public void remove(Integer t){
   if(telefones.contains(t)){
     telefones.remove(t);
   }
   else{
     System.out.println("Número não existe para ser removido");
   }
 }
   
}
 
 
 
  


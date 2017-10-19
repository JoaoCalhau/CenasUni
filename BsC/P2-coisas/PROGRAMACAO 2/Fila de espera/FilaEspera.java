public interface FilaEspera<T>{
  public int size();
  public boolean isEmpty();
  public void addElem(T t);
  public T getElem(int i);
  public T remove(int i);
  public void clear();
  public String toString();
  

}



import java.util.*;
public class FilaEsp<T> implements FilaEspera<T>, Comparable<FilaEsp>{
  
  ArrayList<T> fila;
  
  FilaEsp(){
    fila=new ArrayList<T>(100);
  }
  
  public int size(){
    return this.fila.size();
  }
  
  public boolean isEmpty(){
    return this.fila.isEmpty();
  }
  
  public void addElem(T t){
    this.fila.add(T t);
  }
  
  public T getElem(int i){
    this.fila.get(i);
  }
  
  public T remove(int i){
    this.fila.remove(i);
  }
  
  public void clear(){
    this.fila.clear();
  }
  
  
  public String toString(){
    String s=""; 
    Iterator<T> it=lista.iterator();
    while (it.hasNext()){
      s+=String(it.next())+ "\n";
    }
    return s;
  }
  
  
  
  
  
}
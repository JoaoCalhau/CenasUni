public class Zoo{
  private Animal[] zoo;
  private int indice;

  
  public Zoo(int x){
    zoo=new Animal[x];
    indice=0;
  }
  
  public void add(Animal a){
    if(indice<zoo.length){
      zoo[indice]=a;
      indice++;
    }
  }
  
  public int getAnimal(){
    return indice;
  }
    
  
  

}
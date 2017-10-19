class Aula1{
  public static void main(String args[]){
    //System.out.println("Estao a fazer MUIIITO BARULHO!!!!!");
    /*System.out.println("Agora já não");
    int x=10;
    System.out.println(x);*/
    
    int[] a={12,45,90,10,9,-3,1};
    
    int maior=0;
    
    for(int i=0;i<a.length;i++){
      if(a[i]%2==0 && a[i]>maior)
        maior=a[i];
    }
    System.out.println(maior);
    
    int num=63565;
    if (num%5==0)
      System.out.println("E divisivel por 5");
    else
      System.out.println("Nao Ž divisivel por 5");
  }
}
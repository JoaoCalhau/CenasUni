class zero{
  public static void main(String args[]){
    int i=Integer.parseInt(args[0]);
    while(i>0){
      int temp=i%10;
      if(temp==0){
        System.out.println("Existe");
        break;
     }
      else{
        i=i/10;
      }
    }
    if(i==0){
      System.out.println("Não Existe");
    }
  }      
}  
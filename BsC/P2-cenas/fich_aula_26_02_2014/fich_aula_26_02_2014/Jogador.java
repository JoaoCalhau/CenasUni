class Jogador{
  int casa;
  
  Jogador(){
    casa=0;
  }
  
  void recua(int x){
    if(casa-x<0)
      casa=0;
    else
      casa=casa-x;
  }
  
  int avanca(int x){
    casa=casa+x;
    return casa;
  }
  
  void joga(Dado d, int n){
    d.roda(n);
    avanca(d.face());
  }
}
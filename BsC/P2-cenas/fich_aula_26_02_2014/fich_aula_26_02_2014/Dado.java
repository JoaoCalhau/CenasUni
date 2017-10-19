class Dado{
  int face;
  int[] faces={1,2,3,4,5,6};
  
  
  Dado(){
    face=1;
  }
  
  int face(){
    return face;
  }
  
  void roda(int n){
    int x=(face+n-1)%6;
    face=faces[x];
  }
  
}
class Mintraad extends Thread{
  int[] array;
  Handler def;
  int start;
  int slutt;
  int k;

  Mintraad(int[] array, Handler def, int start, int slutt, int k){
    this.array=array;
    this.def=def;
    this.start=start;
    this.slutt=slutt;
    this.k=k;
  }

  public void run(){
    sekvensielSortering();
  }
  void sekvensielSortering(){
    int i , t ;
    for (int u = start ; u < start+k-1; u++) {
      t = array[u+1] ;
      i = u;
      while ( i >= start && array[i] < t ) {
        array[i+1] = array[i] ;
        i--;
      }
      array[i+1] = t ;
    }
    sekvSort();
  }
  void sekvSort(){
    int minste = array[start+k-1];
    int i , t ;
    for ( int u = start+k-1 ; u < slutt-1; u++) {
      t = array[u+1] ;
      i = u;
      if(t>minste){
        while ( i >= start && array[i] < t ) {
          array[i+1] = array[i] ;
          i--;
        }
        minste = array[start+k-1];
      }
      array[i+1] = t ;
    }


    def.synkroniserArray(array, start);
  }


}

class Mintraad extends Thread{
  int[] array;
  Handler def;
  int start;
  int slutt;
  int antallPlasser;

  //lager et sortert array
  int[] nyArray;

  Mintraad(int[] array, Handler def, int start, int slutt, int antallPlasser){
    this.array=array;
    this.def=def;
    this.start=start;
    this.slutt=slutt;
    this.antallPlasser=antallPlasser-1;
    nyArray= new int[slutt-start];
  }

  public void run(){
    // System.out.println("start: " + start);
    // System.out.println("slutt: " + slutt );
    // System.out.println("antallPlasser: " + antallPlasser);
    // /* sorterer største forst
    int i , t ;
    for ( int k = start ; k < slutt ; k++) {
      t = array[k+1] ;
      i = k ;
      //TODO: sjekke om verdien skal flyttes frammover
      for(int d = start; d<start+antallPlasser; d++){
        if(array[k]>array[d]){

          while ( i >= start && array[i] < t ) {
            array[i +1] = array[i] ;
            i--;
          }
          array[i+1] = t ;

        }
      }
    }


// */
   // 	System.out.println("Thread ferdig");
   	def.synkroniserArray(array, start, slutt);
  }

}

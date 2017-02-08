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
    System.out.println("start: " + start);
    System.out.println("slutt: " + slutt );
    System.out.println("antallPlasser: " + antallPlasser);
    // /* sorterer minste forst
    int i , t ;
    for ( int k = start ; k < slutt-1 ; k++) {
      t = array[k+1] ;
      i = k ;
      while ( i >= start && array[i] < t ) {
        array[i +1] = array[i] ;
        i--;
      }
      array[i+1] = t ;
    }
// */
  	/*
    System.out.println("runnning");


    //sorterer ut de k høyeste tellene i rekkefølge
    int verdi, l, minste=array[start];

   	for (int i=start+1; i<slutt-1; i++) {
   		verdi=array[i];
   		// sjekker om det tallet skal flyttes fram
   		if(verdi>=minste){
   			int k=antallPlasser;
        l=i;
   			while(verdi>array[l]){
   				array[l]=array[l-1];
   				array[l-1]=verdi;
   				l--;
   				if(l==0){
   					array[k]=verdi;
   					System.out.println("break");
   					break;
   				}
   			}
        if(i>k){
          minste=array[k];
        }

   		}
 	}
  */
// /*
 	for (int u=0; u<100; u++) {
 		System.out.println(array[u]);
 	}
// */
   	System.out.println("Thread ferdig");
   	def.synkroniserArray(array, start, slutt);
  }

}

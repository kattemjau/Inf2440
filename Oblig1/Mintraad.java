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
    this.antallPlasser=antallPlasser;
    nyArray= new int[slutt-start];
  }

  public void run(){

  	int i , t ;
  	for ( int k = start ; k < slutt-1 ; k++) {
  		t = array[k+1] ;
  		i = k ;
  		while ( i >= start && array[i] > t ) {
  			array[i +1] = array[i] ;
  			i--;
  		}
  		array[i+1] = t ;
  	}
  // }
  	/*
    System.out.println("runnning");
    

    //sorterer ut de k høyeste tellene i rekkefølge
    int verdi, minste=array[start];

   	for (int i=start+1; i<slutt; i++) {
   		verdi=array[i];

   		// sjekker om det tallet skal flyttes fram
   		if(verdi>minste){
   			int k=antallPlasser;
   			//array out of bound
   			while(verdi>array[k]){
   				array[k]=array[k-1];
   				array[k-1]=verdi;
   				k--;
   				if(k==0){
   					array[k]=verdi;
   					System.out.println("break");
   					break;
   				}
   			}
   		}
 	}

 	for (int i=0; i<100; i++) {
 		System.out.println(array[i]);
 	}
*/
   	System.out.println("Thread ferdig");
   	def.synkroniserArray(array, start, slutt);
  } 

}

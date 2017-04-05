class FindCount implements Runnable{
	int index;
	int start;
	int slutt;
	int[] count;
	int acumVal;
	MultiRadix pointer;


	public FindCount(int index, int start, int slutt, int[] count, MultiRadix pointer ){
		this.index=index;
		this.start=start;
		this.slutt=slutt;
		this.count=count;
		this.acumVal=0;
		this.pointer=pointer;

	}
	public void run(){
		System.out.println("THREAD START " + index);
		int j;
		// endre for starts verdi i array copien
 		for (int i = start; i <= slutt; i++) {
			System.out.print(count[i]);
 			j = count[i];
 			count[i] = acumVal;
 			acumVal += j;
 		}
		System.out.println();
		/*
		int[] array=new int[slutt-start];
		for(int i=0; i<slutt-start; i++){
			array[i]=count[start+1];
		} */
		pointer.schmood(index, count, slutt, start);
	}
}

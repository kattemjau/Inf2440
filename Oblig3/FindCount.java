class FindCount implements Runnable{
	int index;
	int start;
	int slutt;
	int[] count;
	int acumVal;


	public FindCount(int index, int start, int slutt, int[] count, int acumVal){
		this.index=index;
		this.start=start;
		this.slutt=slutt;
		this.count=count;
		this.acumVal=acumVal;

	}
	public void run(){
		int j;
 		for (int i = start; i <= slutt; i++) {
 			j = count[i];
 			count[i] = acumVal;
 			acumVal += j;
 		}
	}
}
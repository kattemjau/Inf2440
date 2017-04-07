
class Traad extends Thread{
	// int n;
	int start;
	int slutt;
	int[] a;
	int[] b, count;
	Sekvensiell pointer;
	int mask, shift;


	public Traad(Sekvensiell pointer, int[] a, int[] b, int start, int slutt, int[] count, int shift, int mask){
		// this.n=n;
		this.start=start;
		this.slutt=slutt;
		this.a=a;
		this.b=b;
		this.count=count;
		this.pointer=pointer;
		this.mask=mask;
		this.shift=shift;

	}
	public void run(){
		int j, acumVal=0;
		for (int i = 0; i <= mask; i++){
			j = count[i];
			count[i] = acumVal;
			acumVal += j;
		}
		for (int i = start; i < pointer.n; i++) {
				b[count[(a[i]>>>shift) & mask]++] = a[i];
		}

	}

}

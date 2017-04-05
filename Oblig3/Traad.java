
class Traad implements Runnable{
	int index;
	int start;
	int slutt;
	int[] a;
	int[] b, count;
	Sekvensiell pointer;
	int mask, shift;


	public Traad(int index, Sekvensiell pointer, int[] a, int[] b, int start, int slutt, int[] count, int shift, int mask){
		this.index=index;
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
		 // d) move numbers in sorted order a to b
		for (int i = start; i < slutt; i++) {
			//venter pa tur til a skrive
			int k=(a[i]>>>shift) & mask;
			// System.out.println(k);
			while(pointer.cont(k, index)){}
			b[count[(a[i]>>>shift) & mask]++] = a[i];
		}

	}

}

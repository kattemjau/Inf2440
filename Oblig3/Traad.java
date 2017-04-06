
class Traad extends Thread{
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
		//  System.out.println("Thread: " + index + " Starter paa : " + start + " slutter paa: " + slutt);
		for (int i = 0; i < index; i++) {

			int variabel = (a[i]>>>shift) & mask;
			if(variabel>=start && variabel<slutt){
				b[count[variabel]++] = a[i];

			}

			// pointer.cont(0, index);
		}

	}

}

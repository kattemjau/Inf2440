import java.util.concurrent.CyclicBarrier;

class OppgB extends Thread{
	int start, slutt, shift, mask;
	int[] count, a, bare, allcount;
	int[][] b, gammelCount;
	int index; CyclicBarrier barrier;
	boolean doPartD = false;


	public OppgB(int index, CyclicBarrier barrier, int start, int slutt, int[] a, int[][] b, int shift, int mask, int[][] gammelCount, int[] allcount, int[] bare){
		// this.count=count;
		this.index=index;
		this.barrier = barrier;
		this.start=start;
		count = new int[mask+1];
		this.shift=shift;
		this.mask=mask;
		this.slutt=slutt;
		this.a=a;
		this.b=b;
		this.bare = bare;
		this.allcount=allcount;
		this.gammelCount=gammelCount;
	}
	public void run(){
		// System.out.println("index " + index);
		int acumVal=0, j;
		// System.out.println("Mask:" + mask + ", skift: " + shift);

		for (int i =start; i <slutt; i++) { //b finn allcount
			count[(a[i]>>> shift) & mask]++;  //teller alle instances

		}
		for (int i = 0; i <= mask; i++){
			gammelCount[index][i]=count[i];

			j = count[i];
			b[index][i] = acumVal;
			acumVal += j;
		}
		// for (int i=0;i<count.length ;i++ ) {
		//   b[index][i]=count[i];
		//   // allcount[count[i]]++;
		// }
		// synkronisering
		try {
			barrier.await();
		} catch (Exception ex) {}
		while (!doPartD) { try { wait(); } catch (Exception ex) {} }

		oppgD();
	}
	public void oppgD(){
		//telle opp hvor mange plasser før denne == startplass
		int[] plasser=new int[mask+1];
		for (int i=0;i<mask+1;i++ ) {
			for (int w =0; w < index; w++) {
				//legge sammen sma arrays + startverdi til den forrige
				plasser[i]+=gammelCount[w][i];
			}
			// plasser[i]+=allcount[i];
		}
		// try {
		//
		// for (int i = 0; i < allcount.length; i++ ) {
		//   System.out.println(i + " " + allcount[i]);
		// }

		// System.out.println("index: " + index + " start: " + start + " stopp: " + slutt);


		for (int i = start; i < slutt; i++) {
			int pos = ((a[i]>>>shift) & mask);
			// System.out.println("Index: " + index + " a[i]: " + a[i] + " allcount[pos] " + allcount[pos] + " Plasser "+ plasser[pos]);
			bare[allcount[pos] + plasser[pos]++] = a[i];
			// plasser[pos]++;

			// }
		}

	//sekvensiell test kode
	// if(index==1){
	//   for (int i = 0; i < a.length; i++) {
	//     bare[allcount[(a[i]>>>shift) & mask]++] = a[i];
	//   }
	// }


	}

	public synchronized void startD() {
		doPartD = true;
		notify();
	}
}

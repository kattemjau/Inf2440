import java.util.*;
import java.util.concurrent.*;
/***********************************************************
* Oblig 3 - sekvensiell kode, INF2440 v2017.
*           Mal laget av: Ifi, Uio, Arne Maus
						Parralisering av: $<, Sindrech
* for store verdier av n > 100 m, kjør (f.eks):
*     >java -Xmx16000m MultiRadix 1000000000
************************************************************/
class MultiRadix{
	int n;
	int [] a;
	final static int NUM_BIT = 7; // alle tall 6-11 .. finn ut hvilken verdi som er best

	public static void main(String [] args) {
		if (args.length != 1) {
			System.out.println(" bruk : >java SekvensiellRadix <n> ");
		} else {
			int n = Integer.parseInt(args[0]);
			MultiRadix test = new MultiRadix();
			test.doIt(n);
		}
	} // end main


	void doIt (int len) {
		a = new int[len];
		Random r = new Random(123);
		for (int i =0; i < len;i++) {
			a[i] = r.nextInt(len);
		}
		a = radixMulti(a);
	} // end doIt

	int[] radixMulti(int[] a) {
		long tt = System.nanoTime();
		  // 1-5 digit radixSort of : a[]
		int max = a[0], numBit = 2, numDigits, n =a.length;
		int [] bit ;

		 // a) finn max verdi i a[]
		for (int i = 1 ; i < n ; i++)
			if (a[i] > max) max = a[i];
		  while (max >= (1L<<numBit) )numBit++; // antall binaere siffer i max

		  // bestem antall bit i numBits sifre
		  numDigits = Math.max(1, numBit/NUM_BIT);
		  bit = new int[numDigits];
		  int rest = (numBit%numDigits), sum =0;;

		  // fordel bitene vi skal sortere paa jevnt
		  for (int i = 0; i < bit.length; i++){
		  	bit[i] = numBit/numDigits;
		  	if ( rest-- > 0)  bit[i]++;
		  }

		  int[] t=a, b = new int [n];

		  for (int i =0; i < bit.length; i++) {
			  radixSort( a,b,bit[i],sum );    // i-te siffer fra a[] til b[]
			  sum += bit[i];
			  // swap arrays (pointers only)
			  t = a;
			  a = b;
			  b = t;
			}
			if (bit.length%2 != 0 ) {
			  // et odde antall sifre, kopier innhold tilbake til original a[] (nå b)
				System.arraycopy (a,0,b,0,a.length);
			}

			double tid = (System.nanoTime() -tt)/1000000.0;
			System.out.println("\nSorterte "+n+" tall paa:" + tid + "millisek.");
			System.out.println("testing sorted array");
			testSort(a);
			System.out.println("done");
			return a;
	 } // end radixMulti

	 /** Sort a[] on one digit ; number of bits = maskLen, shiftet up 'shift' bits */
	 void radixSort ( int [] a, int [] b, int maskLen, int shift){
	 	System.out.println(" radixSort maskLen:"+maskLen+", shift :"+shift);
	 	int  acumVal = 0, j, n = a.length;
	 	int mask = (1<<maskLen) -1;
	 	int [] count = new int [mask+1];
		// System.out.println(count.length);

		 // b) count=the frequency of each radix value in a
	 	for (int i = 0; i < n; i++) {
	 		count[(a[i]>>> shift) & mask]++;
	 	}
	 	// for(int i=0; i<mask; i++){
	 	// 	System.out.print(count[i]);
	 	// }

		  // finner threads og oppretter threadpool
	 	int cores = Runtime.getRuntime().availableProcessors();
	 	ExecutorService pool = Executors.newFixedThreadPool(cores+1);

	 	//liste med thread pekere
	 	List <Future> liste = new Vector <Future>();

	 	int nr=(mask+1)/cores;
	 	int rest= (mask+1)%cores;

		// System.out.println("total: " + (nr*cores+rest));

	 	int start=0, slutt=nr+rest;
		sorted=new int[cores][];

		 // c) Add up in 'count' - accumulated values
	 	for (int w =0; w < cores; w++) {
	 		sorted[w]= new int[slutt-start];
			Thread traad = new Thread(new FindCount(w, start, slutt, Arrays.copyOf(count, count.length), this));
			// System.out.println("sorts from: " + start + " to " + slutt);
 			liste.add(pool.submit(traad)); // submit starter tråden
 			start=slutt;
 			slutt=start+nr;
 		}
 		//test print
		// printSorted();
		pool.shutdown();

		//2d til 1d array (sorted[i-1][sorted[i-1].length-1])
		int teller=0;
		int lastLength=0;
		for(int i =0; i<cores; i++){
			if(i>0)lastLength=count[teller-1];
			System.out.println("lastlength " +lastLength);
			for(int k=1; k<sorted[i].length; k++){
				// if(sorted[i][k]==0){
				// 	lastLength=k;
				// 	break;
				// }
					// System.out.println(sorted[i][k] + " " + lastLength);
					count[teller]=((sorted[i][k])+lastLength);


				teller++;
			}
		}
		System.out.println("teller ." + teller);

		while(teller<count.length){count[teller]=lastLength; teller++;}

		//debug print av hele count. burde vere i stigende rekkefolge.
		for(int i=0; i<count.length;i++)	System.out.println(count[i]);

		sorted=null;
		

		 // d) move numbers in sorted order a to b
 		for (int i = 0; i < n; i++) {
 			b[count[(a[i]>>>shift) & mask]++] = a[i];
 		}

	}// end radixSort

	private int[][] sorted;
	synchronized void schmood(int index, int[] arr, int slutt, int start){
		 			// if(index==11)

		// System.out.println("INDEX: " + index);
		for(int i=0; i<slutt-start; i++){
			sorted[index][i]=arr[start+i];
			// if(index==11)
			// System.out.println(arr[start+i]);
		}
	}
	void printSorted(){
		// System.out.println(sorted[i].length-1);
		for(int i =0; i<sorted.length; i++){
			System.out.println("Index: " + i + " = ");
			for(int k=1; k<sorted[i].length; k++){
				System.out.print(sorted[i][k] + " ");

			}
			System.out.println();
		}
	}


	void testSort(int [] a){
		for (int i = 0; i< a.length-1;i++) {
			if (a[i] > a[i+1]){
				System.out.println("SorteringsFEIL pa plass: "+i +" a["+i+"]:"+a[i]+" > a["+(i+1)+"]:"+a[i+1]);
				return;
			}
		}
	 }// end simple sorteingstest
}// end SekvensiellRadix

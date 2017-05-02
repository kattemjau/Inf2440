import java.util.*;
import java.util.concurrent.*;
/***********************************************************
* Oblig 3 - sekvensiell kode, INF2440 v2017.
*            Ifi, Uio, Arne schmos
* for store verdier av n > 100 m, kjør (f.eks):
*     >java -Xmx16000m MultiRadix 1000000000
************************************************************/
class Sekvensiell{
	// int n;
	volatile int[] a;
	int cores;
	final static int NUM_BIT = 7; // alle tall 6-11 .. finn ut hvilken verdi som er best
	private static double sekvtid;
	public static void main(String [] args) {
		if (args.length != 1) {
			System.out.println(" bruk : >java SekvensiellRadix <n> ");
		} else {
			int n = Integer.parseInt(args[0]);
			sekvtid = new Sekv.MultiRadix().doIt(n);
			new Sekvensiell().doIt(n);
		}
	} // end main

	void doIt (int len) {
		cores = Runtime.getRuntime().availableProcessors();
		a = new int[len];
		Random r = new Random(123);
		for (int i =0; i < len;i++) {
			a[i] = r.nextInt(len);
		}
		a = radixMulti(a);
	} // end doIt

	int max;

	int[]  radixMulti(int [] a) {
		// 1-5 digit radixSort of : a[]
		int numBit = 2, numDigits, n =a.length;
		int [] bit ;
		int[] t=a, b = new int [n];
		max=a[0];

		OppgA[] wut = new OppgA[cores];

		long tt = System.nanoTime();
		int nr=n/cores;
		int start=1, slutt=nr+n%cores;
		for(int i=0;i<cores;i++){
			wut[i]=new OppgA(start, slutt, a);
			wut[i].start();
			start=slutt;
			slutt=start+nr;
		}

		for(OppgA e: wut){
			try{
				e.join();
				if(e.max>max)max=e.max;
			}catch(Exception y){
			}
		}
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

		double tid = (System.nanoTime() -tt)/(double)1000000.0;
		System.out.println("\nSorterte "+n+" tall paa:" + tid + "millisek.");
		System.out.println("Speedup for n=" + n + " Speedup: " + (sekvtid/tid));
		testSort(a);
		return a;
	} // end radixMulti

	// int[] radixMulti(int [] a) {
	// 	  // 1-5 digit radixSort of : a[]
	// 	  int max = a[0], numBit = 2, numDigits, n =a.length;
	// 	  int [] bit ;
	// 	  long tt = System.nanoTime();
	//
	// 	 // a) finn max verdi i a[]
	// 	  for (int i = 1 ; i < n ; i++)
	// 		   if (a[i] > max) max = a[i];
	// 	  while (max >= (1L<<numBit) )numBit++; // antall binaere siffer i max
	//
	// 	  // bestem antall bit i numBits sifre
	// 	  numDigits = Math.max(1, numBit/NUM_BIT);
	// 	  bit = new int[numDigits];
	// 	  int rest = (numBit%numDigits), sum =0;;
	//
	// 	  // fordel bitene vi skal sortere paa jevnt
	// 	  for (int i = 0; i < bit.length; i++){
	// 		  bit[i] = numBit/numDigits;
	// 	      if ( rest-- > 0)  bit[i]++;
	// 	  }
	//
	// 	  int[] t=a, b = new int[n];
	//
	// 	  for (int i =0; i < bit.length; i++) {
	// 		  radixSort( a,b,bit[i],sum );    // i-te siffer fra a[] til b[]
	// 		  sum += bit[i];
	// 		  // swap arrays (pointers only)
	// 		  t = a;
	// 		  a = b;
	// 		  b = t;
	// 	  }
	// 	  if (bit.length%2 != 0 ) {
	// 		  // et odde antall sifre, kopier innhold tilbake til original a[] (nå b)
	// 		  System.arraycopy (a,0,b,0,a.length);
	// 	  }
	//
	// 	  double tid = (System.nanoTime() -tt)/(double)1000000.0;
	// 	  System.out.println("\nSorterte "+ n +" tall paa:" + tid + "millisek.");
	// 	  System.out.println("Speedup for n=" + n + " Speedup: " + (sekvtid/tid));
	//
	// 	  testSort(a);
	// 	  return a;
	//  } // end radixMulti

	int[][] dobbelArray;
	int[][] gammelCount;

	void radixSort ( int [] a, int [] b, int maskLen, int shift){
		// System.out.println(" radixSort maskLen:"+maskLen+", shift :"+shift);
		int  acumVal = 0, j, n = a.length;
		int mask = (1<<maskLen) -1;
		int[] count = new int [mask+1];

		// b) count=the frequency of each radix value in a
		// for (int i = 0; i < n; i++) {
		// 	count[(a[i]>>> shift) & mask]++;
		// }

		int nr=n/cores;
		int start=0, slutt=nr+n%cores;
		OppgB[] array = new OppgB[cores];

	    // int[] allcount= new int[mask+1];
		dobbelArray=new int[cores][mask+1];
		gammelCount=new int[cores][mask+1];
		for (int w =0; w < cores; w++) {
			// dobbelArray[w]=new int[slutt-start];
			array[w]= new OppgB(w, start, slutt, a, dobbelArray, shift, mask, gammelCount, count, b);
			// System.out.println("index: " + w + " start: " + start + " stopp: " + slutt);
			array[w].start();
			start=slutt;
			slutt=start+nr;

		}

		//venter pa traader
		for(OppgB e: array){
			try{
				e.join();
			}catch(Exception y){
			}
		}

		//count all instences and put in count
		for (int i=0;i<count.length ;i++ ) {
			for (int w =0; w < cores; w++) {
				count[i]+=dobbelArray[w][i];
			}
		}



		// c) Add up in 'count' - accumulated values
		// for (int i = 0; i <= mask; i++){
		// 	j = count[i];
		// 	count[i] = acumVal;
		// 	acumVal += j;
		// }
		//prints count
		// for (int i = 0; i < count.length; i++) {
		// 	System.out.print(count[i] + " ");

		// }
		// debug print av hele count. burde vere i stigende rekkefolge.

		// d) move numbers in sorted order a to b
		// for (int i = 0; i < n; i++) {
		// 	b[count[(a[i]>>>shift) & mask]++] = a[i];
		// }


		//TODO D://
		for (int w =0; w < cores; w++) {
			array[w].oppgD();
		}

		//venter pa synkroniseringen
		for(OppgB e: array){
			try{
				e.join();
				// Thread.sleep(100);
			}catch(Exception y){
			}
		}
		//TODO:sett inn i felles array i traaden?


	}// end radixSort

	// synchronized void settSammen(int index, int[] b){
	//
	// }


	void testSort(int [] a){
		for (int i = 0; i< a.length-1;i++) {
			// System.out.println(a[i]);
			if (a[i] > a[i+1]){
				System.out.println("SorteringsFEIL pa plass: "+i +" a["+i+"]:"+a[i]+" > a["+(i+1)+"]:"+a[i+1]);
				return;
				// try{
				// 	Thread.sleep(100);
				// }catch(Exception y){
				// }

			}
		}
	}// end simple sorteingstest
}// end SekvensiellRadix

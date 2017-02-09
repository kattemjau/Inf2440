import java.util.concurrent.*;
import java.util.*;

class Handler{
	int[] nyArray;
	CyclicBarrier barrier = new CyclicBarrier(7);

	void run(int[] array){
		double[] tiderK20;
		double[] tiderK100;
		Mintraad[] k20= new Mintraad[7];
		Mintraad[] k100= new Mintraad[7];
// /*
		long tik = System.nanoTime();
		Integer[] newArray = new Integer[array.length];
		int w = 0;
		for (int value : array) {
    	newArray[w++] = Integer.valueOf(value);
		}

		Arrays.sort(newArray, Collections.reverseOrder());
		/*
		for(int i =0; i<20; i++){
			System.out.println("backupAr: " + newArray[i]);
		} */
		System.out.println("tid pa Array.sort: " + ((System.nanoTime()-tik)/1000000.0));
// */


		try{
			System.out.println("Testing av instikk sortering A2");
			tiderK20=new double[7];
			nyArray = new int[array.length];
			int  k=20;



			for(int i=0; i<7; i++){
				int start = i*array.length/7;
				int slutt = start+array.length/7;
				// System.out.println("slutt: " + slutt);
				// System.out.println("start: " + start);
				long tid = System.nanoTime();
				k20[i] = new Mintraad(array, this, start, slutt, k);
				k20[i].start();
				tiderK20[i]=(System.nanoTime()-tid)/1000000.0;

			}

			for(Mintraad e: k20){
				try{
					e.join();
				}catch(Exception y){}
			}

			// Tidene pa traadene
			System.out.println("Times per thread in order to finishing K20");
			double gjennom=0;
			for (int i=0; i<tiderK20.length; i++) {
				System.out.println("Trad[" + i + "]: " + tiderK20[i]);
				gjennom = gjennom + tiderK20[i];
			}
			System.out.println("Gjennomsnitts tiden K20: " + gjennom/tiderK20.length);


			System.out.println("start: " + 0);
	    System.out.println("slutt: " + nyArray.length );
	    System.out.println("antallPlasser: " + k);



			// /*
						//siste sortering!
						int q, t ;
						for ( int o = 0 ; o < nyArray.length-1 ; o++) {
							t = nyArray[o+1] ;
							q= o ;
							//TODO: sjekke om verdien skal flyttes frammover
							for(int d = 0; d<nyArray.length; d++){
								if(nyArray[o]>nyArray[d]){
									while ( q>= 0 && nyArray[q] < t ) {
										nyArray[q +1] = nyArray[q] ;
										q--;
									}
									nyArray[q+1] = t ;

								}
							}
						}


			// */


/*
			//pintring sorted array
			for (int u=0; u<k; u++) {
		 		System.out.println(nyArray[u]);
		 	}
// */
			// barrier.await();
			// System.out.println("No error");
		}catch(Exception e){
			System.out.println("error running thread K20");
		}
// /*

		Arrays.fill(nyArray, 0);

		try{
			tiderK100=new double[7];
			nyArray = new int[array.length];
			int  k=100;
			for(int i=0; i<7; i++){
				int start = i*array.length/7;
				int slutt = start+array.length/7;
				long tid = System.nanoTime();
				k100[i] = new Mintraad(array, this, start, slutt, k);
				k100[i].start();
				tiderK100[i]=(System.nanoTime()-tid)/1000000.0;

			}

			for(Mintraad e: k100){
				try{
					e.join();
				}catch(Exception y){}
			}
			System.out.println("fortsetter");

			// Tidene pa traadene
			System.out.println("Times per thread in order to finishing for K100");
			double gjennom=0;
			for (int i=0; i<tiderK100.length; i++) {
				System.out.println("Trad[" + i + "]: " + tiderK100[i]);
				gjennom = gjennom + tiderK100[i];
			}
			System.out.println("Gjennomsnitts tiden K100: " + gjennom/tiderK100.length);

			// barrier.await();
			// System.out.println("No error");
		}catch(Exception e){
			System.out.println("error running thread K100");
		}


		// /*
		//siste sortering!
		int q, t ;
		for ( int o = 0 ; o < nyArray.length-1 ; o++) {
			t = nyArray[o+1] ;
			q= o ;
			//TODO: sjekke om verdien skal flyttes frammover
			for(int d = 0; d<nyArray.length; d++){
				if(nyArray[o]>nyArray[d]){
					while ( q>= 0 && nyArray[q] < t ) {
						nyArray[q +1] = nyArray[q] ;
						q--;
					}
					nyArray[q+1] = t ;

				}
			}
		}


		// */



		// */
	}
	synchronized void synkroniserArray(int[] array, int st, int sl) {
		for(int i =st; i<sl; i++) {
			nyArray[i]=array[i];

		}
		/*
		for (int u=0; u<9; u++) {
		System.out.println(nyArray[u]);
	}
	System.out.println();
	*/
}
}

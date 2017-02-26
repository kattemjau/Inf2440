import java.util.concurrent.*;
import java.util.*;

class Handler{
	int[] array;
	int k;
	int[] nyArray;
	ArrayList<Integer> resusltater = new ArrayList<>();

	Handler(int[] array, int k){
		this.array=array;
		this.k=k;
	}
	void parralelisering(){
		int cores = Runtime.getRuntime().availableProcessors();

		if(array.length/cores<k){
			System.out.println("for lite arrays, klarer ikke a utnytte threads");
			cores=array.length/k;
			System.out.println("ant traader: " + cores);
		}

		nyArray=new int[k*cores];

		long sekSort = System.nanoTime();
		int nr = array.length/cores;
		//legg til 4 ekstra pa siste
		int rest = array.length%cores;
		int start=0, slutt;

		Mintraad[] temp = new Mintraad[cores];

		//parralellisere svaret
		for(int i=0; i<cores; i++){

			if(i>cores-rest-1){slutt=nr+start;				
			}else{slutt=nr+start-1;}
			// System.out.println("checking from: " + start + " til " + slutt);
			temp[i] = new Mintraad(array, this, start, slutt, k);
			temp[i].start();
			start=++slutt;
		}

		for(Mintraad e: temp){
			try{
				e.join();
			}catch(Exception y){}
		}

 // sorterings algorithmen

		int counter=0;
		for(Integer e: resusltater){
			nyArray[counter]=e;
			counter++;
		}

		int i , t ;
		for ( int u = 0 ; u < k-1; u++) {
			t = nyArray[u+1] ;
			i = u;
			while ( i >= 0 && nyArray[i] < t ) {
				nyArray[i+1] = nyArray[i] ;
				i--;
			}
			nyArray[i+1] = t ;
		}


		int minste = nyArray[k-1];
		int g , d ;
		for ( int u = 9 ; u < nyArray.length-1; u++) {
			d = nyArray[u+1] ;
			g = u;
			if(d>minste){
				while ( g >= 0 && nyArray[g] < d ) {
					nyArray[g+1] = nyArray[g] ;
					g--;
				}
				minste = nyArray[k-1];
			}
			nyArray[g+1] = d ;
		}
			

		for(int y =0; y<k; y++){
			// System.out.println("parralell array: " + nyArray[y]);
		} 


		System.out.println("tid pa parralellisering: " + ((System.nanoTime()-sekSort)/1000000.0));
	}

	void sekv(){
		long sekSort = System.nanoTime();
		sekvensielSortering();
		// System.out.println("sekvensiell");
		System.out.println("tid pa sekvensielSortering: " + ((System.nanoTime()-sekSort)/1000000.0));
		for(int y =0; y<k; y++){
			// System.out.println("array: " + array[y]);
		} 
	}

	void arraySort(){
		Integer[] newArray = new Integer[array.length];
		int w = 0;
		for (int value : array) {
			newArray[w++] = Integer.valueOf(value);
		}

		long innebyggetSort = System.nanoTime();

		Arrays.sort(newArray, Collections.reverseOrder());
		// System.out.println("java sort algo");
		System.out.println("tid pa Array.sort: " + ((System.nanoTime()-innebyggetSort)/1000000.0));
		for(int i =0; i<k; i++){
			// System.out.println("backupAr: " + newArray[i]);
		} 
	}
	void sekvensielSortering(){
		int i , t ;
		for ( int u = 0 ; u < k-1; u++) {
			t = array[u+1] ;
			i = u;
			while ( i >= 0 && array[i] < t ) {
				array[i+1] = array[i] ;
				i--;
			}
			array[i+1] = t ;
		}
		sekvSort();
	}
	void sekvSort(){
		int minste = array[k-1];
		int i , t ;
		for ( int u = 9 ; u < array.length-1; u++) {
			t = array[u+1] ;
			i = u;
			if(t>minste){
				while ( i >= 0 && array[i] < t ) {
					array[i+1] = array[i] ;
					i--;
				}
				minste = array[k-1];
			}
			array[i+1] = t ;
		}
	}
	synchronized void synkroniserArray(int[] karray, int st) {
		for(int i =st; i<st+k; i++) {
			resusltater.add(karray[i]);

		}
	}

}

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.LinkedHashMap;


public class Handler{
	private ArrayList<Integer> array = new ArrayList<>();
	private int[] erastothenes;
	private int cores=1;
	private CyclicBarrier vent;
	private LinkedHashMap<Integer, LinkedHashMap<Long, String>> result = new LinkedHashMap<>();
	private int printRekke;

	Handler(){
		//finner ant traader som er mulig pa systemet
		cores = Runtime.getRuntime().availableProcessors();
		System.out.println("ant traader: " + cores);
	}

	void finnParralellPrimtall(int maxtall){
		//for lokke som starter alle traader
		Traad[] traadAr = new Traad[cores];
		vent = new CyclicBarrier(cores+1);

		int nr = 100/cores;
		//legg til 4 ekstra pa siste
		int rest = 100%cores;

		long antPrimtall = maxtall;
		antPrimtall=antPrimtall*antPrimtall - 100;
		long tid = System.nanoTime();


		//opretter ant traader
		for(int i=0; i<cores; i++){

			long[] arry;
			if(i>cores-rest-1){arry = new long[nr+1];
			}else{ arry = new long[nr];}
			// System.out.println("arry lgnth" + arry.length);

			for (int k=0; k<arry.length; k++) {
				arry[k] = antPrimtall;
				// System.out.println("arry : " + k);
				antPrimtall++;
			}
			// System.out.println("test posisjon: " + arry[0] + " indesks: " + i);
			traadAr[i] = new Traad(array, this, arry, i);
			traadAr[i].start();

		}

		for(Traad e: traadAr){
			try{
				e.join();
			}catch(Exception y){}
		}
		System.out.println("tid pa parralell Faktorisering: " + ((System.nanoTime()-tid)/1000000.0) + " ms");
	}

	synchronized void parralellFaktorisering(LinkedHashMap<Long, String> result, int id){
		//traadene gjor utskriften til en traad
		//funksjonen lagrer løsningen
		//synchronized er treig, best med minnst kall
		//eventuell vente pa en spesifikk traad, to print them in sequence
		this.result.put(id, result);
	}

	private int c=0;
	void printResult(){
		for (int k: result.keySet()) {
			if(k==c){
				// System.out.println("rekkefolge: " + k);

				for(String i: result.get(k).values()){
						System.out.println(i);
				}

				c++;
				printResult();
				break;

			}
		}
/*
*/
	}

	void finnPrimtall(int maxtall){
		//sorterings algorithme for a finne primtall
		// kun 2 er enseste partall som er primtall
		// for alle oddetall, sjekk om primtall
		long antPrimtall = maxtall;
		antPrimtall=antPrimtall*antPrimtall;
		System.out.println("tester for antPrimtall: " + antPrimtall);
		long tid = System.nanoTime();
		for (long i=antPrimtall-100;  i<antPrimtall; i++) {
			System.out.print(i + " = ");
			faktorisering(i);
			System.out.println(" ");
		}
		System.out.println("tid pa sekvensiel faktorisering: " + ((System.nanoTime()-tid)/1000000.0) + " ms");
		System.out.println();

	}


//primtall = tall som bare er delelig på seg selv
//sjekke om kan faktoriseres
// if modula == 0 || primtall = true
// rekursiv faktorisering if(n%i != 0){ System.out.print(n/i + " + "); rekursiv(n/i)}

	void faktorisering(long maxtall){
		//denne skal multithreades "tar lengst tid"
		for(Integer i: array){
			if(maxtall%i == 0){
				System.out.print(i + " * ");
				faktorisering(maxtall/i);
				return;
			}
		}
		System.out.print(maxtall);
	}

	void eratosthenesSil(int maxtall){
		System.out.println("eratosthenesSil");
		opprettArray(maxtall);

		long ti = System.nanoTime();
		for(Integer e: erastothenes){
			// System.out.println("testing for "+ e);
			if(e<10 && e!=0){
				int y=2;
				for(int i=y*e; i<maxtall; i=(++y*e)){
					erastothenes[i-2]=0;
					// System.out.println("fjerner: " + i);
					// System.out.println("Y = " + y);
				}
			}else if(e>10){
				break;
			}
		}
		System.out.println("tid pa eratosthenesSil: " + ((System.nanoTime()-ti)/1000000.0) + " ms");

		for(Integer k: erastothenes){
			if(k!=0){
			// System.out.println("primtall: " + k);
				array.add(k);
			}
		}


		// for(int i=0;i<maxtall;i++){
		// 	System.out.println(erastothenes[i]);
		// }

	}

	void opprettArray(int maxtall){
		erastothenes=new int[maxtall];

		for(int i=2; i<maxtall; i++){
			erastothenes[i-2]=i;
			// System.out.println(i);
		}
	}


}

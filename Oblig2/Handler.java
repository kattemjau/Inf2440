import java.util.ArrayList;

public class Handler{
	private ArrayList<Integer> array = new ArrayList<>();
	private int[] erastothenes;

	Handler(){

	}
	void finnPrimtall(int maxtall){
		//sorterings algorithme for a finne primtall
		// kun 2 er enseste partall som er primtall
		// for alle oddetall, sjekk om primtall
		maxtall=maxtall*maxtall;
		long antPrimtall = 4000000000000L;
		System.out.println("tester for antPrimtall: " + antPrimtall);
		long tid = System.nanoTime();
		for (long i=antPrimtall-100;  i<antPrimtall; i++) {
			System.out.print(i + " = ");
			faktorisering(i);		
			System.out.println(" ");	
		}
		System.out.println("tid pa sekvensiel faktorisering: " + ((System.nanoTime()-tid)/1000000.0) + " ms");

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
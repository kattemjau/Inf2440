import java.util.ArrayList;

public class Handler{
	public ArrayList<Integer> array = new ArrayList<>();

	Handler(){

	}
	void finnPrimtall(int antPrimtall){
		//sorterings algorithme for a finne primtall
		// kun 2 er enseste partall som er primtall
		// for alle oddetall, sjekk om primtall
		System.out.println("tester for antPrimtall: " + antPrimtall);

		for (int i = 3; i<antPrimtall; i+=2) {
			// System.out.print(i +" = ");
			faktorisering(i);
			// System.out.println(" ");
			
		}

		for (Integer e: array) {
			System.out.println(e);
		}


	}

	
//primtall = tall som bare er delelig på seg selv
//sjekke om kan faktoriseres
// if modula == 0 || primtall = true
// rekursiv faktorisering if(n%i != 0){ System.out.print(n/i + " + "); rekursiv(n/i)}

	void faktorisering(int potensielPrim){
		//denne skal multithreades "tar lengst tid"
		
		for(int i=2; i<potensielPrim; i++){
			// System.out.println("factorisererer : " + i);
			if(potensielPrim%i == 0){
				// System.out.print(potensielPrim/i);
				if(array.contains(potensielPrim/i)){
					// System.out.print(potensielPrim);
					return;
				}
				// System.out.print(" * ");
				faktorisering(potensielPrim/i);
				return;
			}

		}
		// System.out.println("DEN KJEM HIT");
		// kommer den hit er det et primtall
		//add primtall
		// if(!array.contains(potensielPrim)){
		array.add(potensielPrim);
		// System.out.print(potensielPrim);

		// }


	}


}
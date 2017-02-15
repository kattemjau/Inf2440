
public class Oblig2{
	public static void main(String[] args) {
		try{
		int antPrimtall = args[1];
			
		}catch (Exception e){
			System.out.println("Usage: java Oblig2 'numbers to iterate over'");
		}
		Handler hand = new Handler();
		hand.finnPrimtall(antPrimtall);

	}
}

//primtall = tall som bare er delelig på seg selv
//sjekke om kan faktoriseres
// if modula == 0 || primtall = true
// rekursiv faktorisering if(n%i != 0){ System.out.print(n/i + " + "); rekursiv(n/i)}
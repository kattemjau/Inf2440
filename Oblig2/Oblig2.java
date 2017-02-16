
public class Oblig2{
	public static void main(String[] args) {
		try{
		int antTall = Integer.parseInt(args[0]);
		Handler hand = new Handler();
		// System.out.println(antTall);

		hand.eratosthenesSil(antTall);
		hand.finnPrimtall(antTall);


			
		}catch (NullPointerException e){
			System.out.println("Usage: java Oblig2 'numbers to iterate over'");
		}

	}
}

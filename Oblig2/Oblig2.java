
public class Oblig2{
	public static void main(String[] args) {
		try{
		int antTall = Integer.parseInt(args[0]);
		Handler hand = new Handler();

		hand.erastothenesSil(antTall);
		// hand.finnPrimtall(antTall);

		// hand.finnParralellPrimtall(antTall);
		// hand.printResult();

		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Usage: java Oblig2 'numbers to iterate over'");
		}

	}
}


public class Oblig2{
	public static void main(String[] args) {
		try{
		int antPrimtall = Integer.parseInt(args[0]);
		System.out.println("thiws" + antPrimtall);
		Handler hand = new Handler();
		hand.finnPrimtall(antPrimtall);
			
		}catch (NullPointerException e){
			System.out.println("Usage: java Oblig2 'numbers to iterate over'");
		}

	}
}

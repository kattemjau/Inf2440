
class Oblig4{
	int[] x, y;
	int cores;
	IntList array;
	public static void main(String[] args) {
			int n = Integer.parseInt(args[0]);
			new Oblig4().kul(n);
	}
	void kul(int n){
		//deklarerer variabler
		array=new IntList(n);	//opretter intlist
		cores=Runtime.getRuntime().availableProcessors();	//setter antall procs
		x=new int[n]; y=new int[n];
		NPunkter17 punkter = new NPunkter17(n);	//opretter ytt objekt
		punkter.fyllArrayer(x, y);	//fyller ut punkter

		Long time = System.nanoTime();
		new Oblig4().sekvensiell(x, y);
		double sekvtid = (System.nanoTime() -time)/(double)1000000.0;
		System.out.println("\nSorterte "+n+" tall paa:" + sekvtid + "millisek.");
		time = System.nanoTime();
		parralell();
		double tid = (System.nanoTime() -time)/(double)1000000.0;
		System.out.println("Speedup for n=" + n + " Speedup: " + (sekvtid/tid));


	}
	void sekvensiell(int[] x, int[] y){

	}void parralell(){

	}

}

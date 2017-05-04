import java.util.HashMap;


class Oblig4{
	int[] x, y;
	int cores, MAX_Y=0, MAX_X=0, MIN_X=0, n;
	IntList array;
	public static void main(String[] args) {
			int n = Integer.parseInt(args[0]);
			new Oblig4().kul(n);
	}
	void kul(int n){
		//deklarerer variabler
		this.n=n;
		array=new IntList(n);	//opretter intlist
		cores=Runtime.getRuntime().availableProcessors();	//setter antall procs
		x=new int[n]; y=new int[n];
		NPunkter17 punkter = new NPunkter17(n);	//opretter ytt objekt
		punkter.fyllArrayer(x, y);	//fyller ut punkter

		Long time = System.nanoTime();
		sekvensiell();
		double sekvtid = (System.nanoTime() -time)/(double)1000000.0;
		System.out.println("\nSorterte "+n+" tall paa:" + sekvtid + "millisek.");
		time = System.nanoTime();
		parralell();
		double tid = (System.nanoTime() -time)/(double)1000000.0;
		System.out.println("\nSorterte "+n+" tall paa:" + tid + "millisek.");
		System.out.println("Speedup for n=" + n + " Speedup: " + (sekvtid/tid));


	}
	int xmin=0, xmax=0, ymax=0, ymin=0;
	void sekvensiell(){
		finn();
		MAX_X=x[xmax];
		MIN_X=x[xmin];
		MAX_Y=y[ymax];

		System.out.println("xmax: " + xmax + " xmin: " + xmin);
		//starter med xmin til ymax
		array.add(xmax);
		lagStreker(ymax, xmax);
		array.add(ymax);
		lagStreker(xmin, ymax);
		array.add(xmin);
		lagStreker(ymin, xmin);
		array.add(ymin);
		lagStreker(xmax, ymin);
		// System.out.println(strek(xmin, xmax, ymin));


		System.out.print("Streker fra: ");
		for(int i=0; i<array.size(); i++){
			System.out.print(array.get(i) + " ");
		}

		TegnUt print=new TegnUt(this, array, "string");

	}void parralell(){

	}
	void finn(){
		for(int i=1; i<n;i++){
			if(x[i]<x[xmin]){
				xmin=i;
			}
			if(x[i]>x[xmax]){
				xmax=i;
			}
			if(y[i]>y[ymax]){
				ymax=i;
			}
			if(y[i]<y[ymin]){
				ymin=i;
			}
		}

	}void lagStreker(int p1, int p2){
		System.out.println("Sjekker for P1: " + p1 + " og P2: " + p2);
		HashMap<Integer, Double> map = new HashMap<>();
		for(int i=0; i<n;i++){
			// if(x[i]<x[p2] && y[i]<y[p1]){	//endres
				double temp=strek(p1, p2, i);
				if(temp>=0){
					map.put(i, temp);
				}
			// }
		}
			// finne den storste
		double max=0;
		int tall=0; //0 er pa linja
		for(Integer e: map.keySet()){
			// array.add(e);
			if(map.get(e)>max){
				max=map.get(e);
				tall=e;
			}
		}
		if(tall==0){
			//sjekk om punkter ligger pa linjen
			while(!map.isEmpty()){
			int min=xmax;
			for(Integer e: map.keySet()){
				if(map.get(e)==0){
					if(x[e]>x[min] && y[e]<y[p1] && y[e] >y[p2]){
						min=e;
					}
				}
			}
			array.add(min);
			map.remove(min);
		}
			return;
		}
		lagStreker(tall, p2);
		array.add(tall);
		lagStreker(p1, tall);
	}
	double strek(int p1, int p2, int p3){
		int a=0, b=0, c=0;
		//finn funksjonen for linje
		// fra p1 til p2
		a=y[p1]-y[p2];
		b=x[p2]-x[p1];
		c=(y[p2]*x[p1]) - (y[p1]*x[p2]);
		return avstand(a, b, c, p3);

	}double avstand(int a, int b, int c, int p3){
		return ((((double)a * (double)x[p3]) + ((double)b * (double)y[p3]) + (double)c)/ (double)Math.sqrt((a * a) + (b * b)));
	}


}

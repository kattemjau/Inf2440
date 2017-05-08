import java.util.HashMap;


class Oblig4{
	int[] x, y;
	int MAX_Y=0, MAX_X=0, MIN_X=0, n;
	IntList array;
	public static void main(String[] args) {
			int n = Integer.parseInt(args[0]);
			new Oblig4().kul(n);
	}
	void kul(int n){
		//deklarerer variabler
		this.n=n;
		x=new int[n]; y=new int[n];
		NPunkter17 punkter = new NPunkter17(n);	//opretter ytt objekt
		punkter.fyllArrayer(x, y);	//fyller ut punkter

		Long time = System.nanoTime();
		sekvensiell();
		double sekvtid = (System.nanoTime() -time)/(double)1000000.0;
		System.out.println("\nSorterte "+n+" tall paa:" + sekvtid + "millisek.");
		// display("Sekvensiell");	//displaying outside of timer

		time = System.nanoTime();
		parralell();
		double tid = (System.nanoTime() -time)/(double)1000000.0;
		// display("parralell");	//displaying outside of timer
		System.out.println("\nSorterte "+n+" tall paa:" + tid + "millisek.");
		System.out.println("Speedup for n=" + n + " Speedup: " + (sekvtid/tid));


	}
	void display(String thing){
		// System.out.print("Streker fra: ");
		for(int i=0; i<array.size(); i++){
			System.out.print(array.get(i) + " ");
		}
		System.out.println();

		// TegnUt print=new TegnUt(this, array, thing);
	}
	int xmin=0, xmax=0, ymax=0, ymin=0;
	void sekvensiell(){
		array=new IntList(n);	//opretter intlist
		finn();
		MAX_X=x[xmax];
		MIN_X=x[xmin];
		MAX_Y=y[ymax];

		// System.out.println("xmax: " + xmax + " xmin: " + xmin);
		//starter med xmin til ymax
		array.add(xmax);
		lagStreker(ymax, xmax, 3);

		array.add(ymax);
		lagStreker(xmin, ymax, 1);

		array.add(xmin);
		lagStreker(ymin, xmin, 2);

		array.add(ymin);
		lagStreker(xmax, ymin, 4);
		// System.out.println(strek(xmin, xmax, ymin));




	}

	void parralell(){
		array=new IntList(n);	//opretter intlist
		finn();
		MAX_X=x[xmax];
		MIN_X=x[xmin];
		MAX_Y=y[ymax];
		//STARTE TRAADER

		array.add(xmax);
		Traad test = new Traad(ymax, xmax, array, x, y, n, 3); //skriver til array
		test.start();

		IntList array1=new IntList(n);	//opretter intlist
		array1.add(ymax);
		Traad test1 = new Traad(xmin, ymax, array1, x, y, n, 1); //skriver til array1
		test1.start();

		IntList array2=new IntList(n);	//opretter intlist
		array2.add(xmin);
		Traad test2 = new Traad(ymin, xmin, array2, x, y, n, 2); //array2
		test2.start();

		IntList array3=new IntList(n);	//opretter intlist
		array3.add(ymin);
		Traad test3 = new Traad(xmax, ymin, array3, x, y, n, 4); //array3
		test3.start();

		//vent paa TRAADER
		try{
		test.join();
		test1.join();
		test2.join();
		test3.join();
	}catch(Exception e){
		System.out.println("error with threads");
	}


		//legg sammen arrays med array.append(array1);
		array.append(array1);
		array.append(array2);
		array.append(array3);

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

	}void lagStreker(int p1, int p2, int num){
		// System.out.println("Sjekker for P1:"+p1+"("+x[p1]+","+y[p1]+")"+ " og P2: " + p2+"("+x[p2]+","+y[p2]+")");
		HashMap<Integer, Double> map = new HashMap<>();

		if(num==1){
			for(int i=0; i<n;i++){
				if(x[i]<=x[p2] && y[i]>=y[p1]){
					double temp=strek(p1, p2, i);
					if(temp>=0){
						map.put(i, temp);
					}
				}
			}
		}else if(num==2){
			for(int i=0; i<n;i++){
				if(x[i]<=x[p1] && y[i]<=y[p2]){
					double temp=strek(p1, p2, i);
					if(temp>=0){
						map.put(i, temp);
					}
				}
			}
		}else if(num==3){
			for(int i=0; i<n;i++){
				if(x[i]>=x[p1] && y[i]>=y[p2]){
					double temp=strek(p1, p2, i);
					if(temp>=0){
						map.put(i, temp);
					}
				}
			}
		}else if(num==4){
			for(int i=0; i<n;i++){
				if(x[i]>=x[p2] && y[i]<=y[p1]){
					double temp=strek(p1, p2, i);
					if(temp>=0){
						map.put(i, temp);
					}
				}
			}
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
				map.remove(p1);
				map.remove(p2);
				// System.out.println("setter avstander");
				// double min=0;
				HashMap<Integer, Double> mul = new HashMap<>();
				for(Integer e: map.keySet()){
					mul.put(e, avstand(p1, e));
					// System.out.print("e ." + e);
					// System.out.println(avstand(p1, e));
					// min=avstand(p1, e);
					// System.out.println("go in here?");
					// temp=e;
				}

				int temp=-1;
			//sjekk om punkter ligger pa linjen
			while(!mul.isEmpty()){
				// temp=1;
				// System.out.println("iterrerer");
			for(Integer e: mul.keySet()){
				if(temp==-1)temp=e;
				 //finn minste
				 if(mul.get(e)>mul.get(temp)){
					//  System.out.println("fant minste");
					//  min=mul.get(e);
					 temp=e;
				 }
			}
			// if(temp!=0)
			array.add(temp);
			mul.remove(temp);
			temp=-1;
		}
			return;
		}
		lagStreker(tall, p2, num);
		array.add(tall);
		lagStreker(p1, tall, num);
	}
	double avstand(int p1, int p2){
		int fk = x[p2] - x[p1];
		int fg = y[p2] - y[p1];
		return Math.abs(Math.sqrt((fk*fk) + (fg*fg)));
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

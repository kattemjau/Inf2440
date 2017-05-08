import java.util.HashMap;

class Traad extends Thread{
	IntList array;
	int p1, p2, n, num;
	int[] x, y;

	Traad(int p1, int p2, IntList array, int[] x, int[] y, int n, int num){
			this.array=array;
			this.p1=p1;
			this.p2=p2;
			this.x=x;
			this.y=y;
			this.n=n;
			this.num=num;

	}public void run(){
		lagStreker(p1, p2, num);
	}

	void lagStreker(int p1, int p2, int num){
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
			int temp=0;
			HashMap<Integer, Double> mul = new HashMap<>();
			for(Integer e: map.keySet()){
				mul.put(e, avstand(p1, e));
				temp=e;
			}

			//sjekk om punkter ligger pa linjen
			while(!mul.isEmpty()){
				// temp=1;
				// System.out.println("iterrerer");
				for(Integer e: mul.keySet()){
					if(temp==-1)temp=e;
					//finn minste
					if(mul.get(e)>mul.get(temp)){
						// System.out.println("fant minste");
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

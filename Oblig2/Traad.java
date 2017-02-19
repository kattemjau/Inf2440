import java.util.ArrayList;

class Traad extends Thread{
	ArrayList<Integer> array;

	Traad(ArrayList<Integer> array){
		this.array=array;
	}
	void run(long maxtall){
		//faktoriserer for et tall
		
		for(Integer i: array){
			if(maxtall%i == 0){
				System.out.print(i + " * ");
				faktorisering(maxtall/i);
				return;
			}
		}
		System.out.print(maxtall);
	}

}
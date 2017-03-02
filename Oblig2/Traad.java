import java.util.ArrayList;
import java.util.LinkedHashMap;

class Traad extends Thread{
	private ArrayList<Integer> array;
	// private int[] array;
	private Handler obj;
	private long[] arry;
	private int id;

	private LinkedHashMap<Long, String> result = new LinkedHashMap<Long, String>();


	Traad(ArrayList<Integer> array, Handler obj, long[] arry, int id){
		this.array=array;
		this.obj=obj;
		this.arry=arry;
		this.id=id;

/*
		System.out.println("printing array");
		for(Integer i: array){
			System.out.println(i);
		}
		System.out.println();
		System.out.println("printing arry");
		for(Long e: arry){
			System.out.println(e);
		} */
	}
	public void run(){
		//faktoriserer for et tall
		for(int i=0; i<arry.length; i++){
			String utskrift = Long.toString(arry[i]);
			// System.out.println("utskrift: " + utskrift);
			utskrift += " = ";
			utskrift += faktorisering(arry[i]);


			result.put(arry[i], utskrift);
		}
		obj.parralellFaktorisering(result, id);

	}
	String faktorisering(long maxtall) {

		for(Integer i: array){
			if(maxtall%i == 0){
				return i + " * " + faktorisering(maxtall/i);
			}
		}
		return Long.toString(maxtall);
// return null;

	}

}

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.HashMap;


public class Handler{
	// private ArrayList<Integer> array = new ArrayList<>();
	private int cores=1;
	// private LinkedHashMap<Integer, LinkedHashMap<Long, String>> result = new LinkedHashMap<>();
	private HashMap<String, Double> tider = new HashMap<>();
	private int maxtall;
	private byte[] bitArr;

	Handler(int maxtall){
		//finner ant traader som er mulig pa systemet
		cores = Runtime.getRuntime().availableProcessors();
		System.out.println("ant traader: " + cores);
		this.maxtall=maxtall;

		// erastothenesSil();
		parralellSil();
		// finnPrimtall();
		// parralellFakto();
		// traadfaktorisering(100);
		// printTider();

	}
	void parralellFakto(){
		// Traad[] traadArray = new Traad[maxtall];
		int tall=maxtall;
		// tall=tall*tall;

		long ti = System.nanoTime();

		for(int i=tall-100; i<tall; i++){
			int k = traadfaktorisering(i);
		}

		long tid = System.nanoTime();
		System.out.println("tid pa parralellFakto: " + ((tid-ti)/1000000.0) + " ms");
		tider.put("parralellFakto", ((tid-ti)/1000000.0));


	}
	private Traad[] fptraad;
	private int number=0;

	int traadfaktorisering(int i){
		fptraad = new Traad[maxtall];
		int counter=0;
		for(int e = nextPrime(2); e<10; e=nextPrime(e)){
			fptraad[counter]=new Traad(false, maxtall, bitArr, e, this);
			fptraad[counter].start();

			counter++;
		}

		counter=0;
		while(counter <600000000){
			if(number>0){
				System.out.println(number);
				int temp=number;
				number=0;
				return temp;
			}
		}
		System.out.println("feil");
		return 0;

	}
	synchronized void yes(int i){
		number=i;
		for(Traad e: fptraad){
			try{
				e.interrupt();
			}catch(Exception y){
			}
		}

	}
	void erastothenesSil(){
		System.out.println("erastothenesSil");
		bitArr = new byte [maxtall];
		opprettArray(maxtall);

		long ti = System.nanoTime();

		for(int e = nextPrime(2); e<212; e=nextPrime(e)){
			// System.out.println("testing for "+ e);

			int y=2;
			for(int i=y*e; i<maxtall; i=++y*e){
				if((i & 1) != 0){
					crossOut(i);
					// System.out.println("fjerner index: " + i);
					// System.out.println("tallet som blir fjernet er: " + i);
				}
			}
			// System.out.println();
		}
		long tid = System.nanoTime();
		System.out.println("tid pa eratosthenesSil: " + ((tid-ti)/1000000.0) + " ms");
		tider.put("eratosthenesSil", ((tid-ti)/1000000.0));
	}
	void parralellSil(){
		bitArr = new byte [maxtall];
		opprettArray(maxtall);

		Traad[] traadArray = new Traad[maxtall];

		long ti = System.nanoTime();
		int counter=0;
		for(int e = nextPrime(2); e<212; e=nextPrime(e)){
			traadArray[counter]=new Traad(true, maxtall, bitArr, e, this);
			traadArray[counter].start();

			// System.out.println();
			counter++;
		}
		long tid = System.nanoTime();
		System.out.println("tid pa parralellSil: " + ((tid-ti)/1000000.0) + " ms");
		tider.put("parralellSil", ((tid-ti)/1000000.0));

	}
	void printTider(){
		System.out.println();
		for (String k: tider.keySet()) {
			System.out.println("Tider for " + k + " " + tider.get(k));
		}
	}
	void crossOut(int i){
		int arrNum = i/14;
		int bitNum = (i%14) >>1;
		// System.out.println("arrNum: " + arrNum + " bitNum  " + bitNum);
		bitArr[arrNum]= (byte) (bitArr[arrNum] & ~(1 << bitNum));
	}
	boolean isPrime (int k){
		if(k==2) return true;
		if(k%2 == 0) return false;
		int arrNum = k/14;
		int bitNum = (k%14) >> 1;
		return (bitArr[arrNum] & 1 << bitNum)  != 0;
	}
	int nextPrime(int i){
		i++;
		while(!isPrime(i)) i++;
		return i;
	}

	void finnPrimtall(){
		//sorterings algorithme for a finne primtall
		// kun 2 er enseste partall som er primtall
		// for alle oddetall, sjekk om primtall
		long antPrimtall = maxtall;
		antPrimtall=antPrimtall*antPrimtall;
		System.out.println("tester for antPrimtall: " + antPrimtall);
		long tid = System.nanoTime();
		for (long i=antPrimtall-100;  i<antPrimtall; i++) {
			System.out.print(i + " = ");
			faktorisering(i);
			System.out.println(" ");
		}
		System.out.println("tid pa sekvensiel faktorisering: " + ((System.nanoTime()-tid)/1000000.0) + " ms");
		System.out.println();
	}
	void printPrim(){

		for(int i=2; i<maxtall; i++){
			if(isPrime(i) && i!=0){
				System.out.println("primtall: " + i);
			}
		}
	}
	void faktorisering(long tall){
		for(int i=2; i<maxtall; i=nextPrime(i)){
			if(i==0){
				return;
			}
			if(tall%i == 0){
				if(tall/i ==1){
					System.out.print(i);
					return;
				}
				System.out.print(i + " * ");
				faktorisering(tall/i);
				return;
			}
		}
		System.out.print(tall);
	}
	void opprettArray(int maxtall){
		for(int i=0; i<bitArr.length; i++){
			bitArr[i]=(byte)127;
		}
	}
}

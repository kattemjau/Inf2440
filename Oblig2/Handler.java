import java.util.*;
import  java.lang.System;


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

		// parralellSil();
		erastothenesSil(maxtall);
		// finnPrimtall();
		parralellFakto();
		// 	finnFeil();
		// printTider();

	}
	void parralellFakto(){
		// Traad[] traadArray = new Traad[maxtall];
		long tall=maxtall;
		tall=tall*tall;	//tallene som skal faktoriseres

		//lagrer faktoriseringen
		ArrayList<Long> fakro = new ArrayList<>();

		long ti = System.nanoTime();
		long k=1;
		for(long i=tall-100; i<tall; i++){
		// long i=3999999999999999991L;
		// System.out.println("i " + i);
				k = traadfaktorisering(i);
				fakro.add(k);
				// System.out.println("k" + k);
				long temp=i/k;
				// System.out.println("temp" + temp);
			while(temp!=1 ) {
				if(temp<maxtall && isPrime((int)temp)){
					fakro.add(temp);
					// System.out.println("is prime" + temp);
					break;
				}
				k = traadfaktorisering(temp);
				// System.out.println("k" + k);
				fakro.add(k);
				temp=temp/k;
				// System.out.println("temp" + temp);

			}
			System.out.print(i + " = ");
			System.out.print(fakro.get(0));
			for(int e=1; e<fakro.size(); e++){
				System.out.print(" * ");
				System.out.print(fakro.get(e));
			}
			fakro.clear();
			System.out.println();
		}

		long tid = System.nanoTime();
		System.out.println("tid pa parralellFakto: " + ((tid-ti)/1000000.0) + " ms");
		tider.put("parralellFakto", ((tid-ti)/1000000.0));



	}
	private Traad[] fptraad;
	private long number=1;

	long traadfaktorisering(long kmam){
		fptraad = new Traad[cores];
		int counter=0;
		number=kmam;

		long nr = maxtall/cores;
		if(kmam%2==0){
			return 2;
		}if(kmam%3==0){
			return 3;
		}if(kmam%5==0){
			return 5;
		}if(kmam%7==0){
			return 7;
		}
		long start=2;
		long slutt=nr;
		for(int i=0; i<cores; i++){

			fptraad[counter]=new Traad(false, kmam, bitArr, start, this, slutt);
			// System.out.println("checking from: " + start + " til " + slutt);
			fptraad[counter].start();
			start=slutt;
			slutt=start+nr;
			counter++;
		}

		for(Traad e: fptraad){
			try{
				e.join();
			}catch(Exception y){
			}
		}
		// System.out.println("number: " + number);
		if(number==1){
			return kmam;
		}
		return number;

	}
	synchronized void yes(long i){
		// System.out.println(number);
		number=i;
		for(Traad e: fptraad){
			try{
				e.interrupt();
			}catch(Exception y){
			}
		}

	}
	void erastothenesSil(int tall){
		bitArr = new byte [maxtall];
		opprettArray(maxtall);
		int lilleTabellen = (int) Math.sqrt(tall) + 1;

		long ti = System.nanoTime();

		for(int e = nextPrime(2); e<lilleTabellen; e=nextPrime(e)){
			// System.out.println("testing for "+ e);

			int y=2;
			for(int i=y*e; i<tall; i=++y*e){
				if((i & 1) != 0){
					crossOut(i);
					// System.out.println("fjerner tall: " + i);
				}
			}
			// System.out.println();
		}
		long tid = System.nanoTime();
		System.out.println("tid pa eratosthenesSil: " + ((tid-ti)/1000000.0) + " ms");
		tider.put("eratosthenesSil", ((tid-ti)/1000000.0));
	}


	void parralellSil(){
		// bitArr = new byte [maxtall];
		// opprettArray(maxtall);
		int lilleTabellen = (int) Math.sqrt(maxtall) + 1;
		Traad[] traadArray = new Traad[lilleTabellen];


		long ti = System.nanoTime();
		erastothenesSil(lilleTabellen);
		int counter=0;

		for(int e = nextPrime(2); e<lilleTabellen; e=nextPrime(e)){
			traadArray[counter]=new Traad(true, maxtall, bitArr, e, this, counter);
			traadArray[counter].start();

			// System.out.println();
			counter++;
		}

		for(Traad e: traadArray){
			try{
				e.join();
			}catch(Exception y){
			}
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
	void finnFeil(){
		for(int e = nextPrime(2); e<maxtall; e=nextPrime(e)){
			if(e==0){
				System.out.println("no error");
				return;
			}

			// System.out.print(e + " = ");
			faktorisering(e);
			// System.out.println(" ");


		}
	}
	void faktorisering(long tall){
		for(int i=2; i<maxtall; i=nextPrime(i)){
			if(i==0){
				return;
			}
			if(tall%i == 0){
				if(tall/i ==1){
					//kommenter ut den under for debug mode
					System.out.print(i);
					return;
				}
				//kommenter ut den under for debug mode
				System.out.print(i + " * ");
				faktorisering(tall/i);
				return;
			}
		}
		//kommenter ut den under for debug mode
		System.out.print(tall);
		return;
	}
	void opprettArray(int maxtall){
		for(int i=0; i<bitArr.length; i++){
			bitArr[i]=(byte)127;
		}
	}
}

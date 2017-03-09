class Traad extends Thread{
	private boolean sil = false;
	private byte[] bitArr;
	private long maxtall;
	private long e;
	private Handler ref;
	private long slutt;

	Traad(boolean sil, long maxtall, byte[] bitArr, long e, Handler ref, long slutt){
		this.sil=sil;
		this.maxtall=maxtall;
		this.bitArr=bitArr;
		this.e=e;
		this.ref=ref;
		this.slutt=slutt;
		// System.out.println(e);

	}
	public void run(){
		if(sil==true){
			pSil();
		}else{
		// System.out.println("starting thread");
			faktorisering();
		}
	}
	void faktorisering(){
		for(long i=e; i<slutt; i=nextPrime((int)i)){
			i=nextPrime((int)i-1);

			if(i==0){
				return;
			}

			if(maxtall%i == 0){
			// System.out.println( "returns: " +i);
				ref.yes(i);
				return;
			}
		}
	}

	void pSil(){
		int n = (int) e;
		int y=2;
		for(int i=y*n; i<maxtall; i=++y*n){
			if((i & 1) != 0){

				crossOut(i);

			}
		}
	}
	void crossOut(int i){
		int arrNum = i/14;
		int bitNum = (i%14) >>1;
		// System.out.println("arrNum: " + arrNum + " bitNum  " + bitNum);
		bitArr[arrNum]= (byte) (bitArr[arrNum] & ~(1 << bitNum));
	}
	int nextPrime(int i){
		i++;
		while(!isPrime(i)) i++;
		return i;
	}
	boolean isPrime (int k){
		if(k==2) return true;
		if(k%2 == 0) return false;
		int arrNum = k/14;
		int bitNum = (k%14) >> 1;
		return (bitArr[arrNum] & 1 << bitNum)  != 0;
	}


	/*
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
	String faktorisering(long tall) {
		for(int i=2; i<maxtall; i=nextPrime(i)){
			if(i==0){
				return "error";
			}
			if(tall%i == 0){
				if(tall/i ==1){
					return Integer.toString(i);
				}
				return i + " * " + faktorisering(tall/i);
			}
		}
		return Long.toString(tall);
	}
	*/


}

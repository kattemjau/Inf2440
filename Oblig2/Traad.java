class Traad extends Thread{
	private boolean sil = false;
	private byte[] bitArr;
	private int maxtall;
	private int e;

	Traad(boolean sil, int maxtall, byte[] bitArr, int e){
		this.sil=sil;
		this.maxtall=maxtall;
		this.bitArr=bitArr;
		this.e=e;

	}
	public void run(){
		if(sil==true){
			pSil();
		}else{

		}
	}

	void pSil(){
		int y=2;
		for(int i=y*e; i<maxtall; i=++y*e){
			if((i & 1) != 0){

				crossOut(i);
				// System.out.println("fjerner index: " + i);
				// System.out.println("tallet som blir fjernet er: " + i);
			}
		}
	}
	void crossOut(int i){
		int arrNum = i/14;
		int bitNum = (i%14) >>1;
		// System.out.println("arrNum: " + arrNum + " bitNum  " + bitNum);
		bitArr[arrNum]= (byte) (bitArr[arrNum] & ~(1 << bitNum));
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

class OppgB extends Thread{
  int start, slutt, shift, mask;
  int[] count, a, b;

  public OppgB(int index, int start, int slutt, int[] count, int[] a, int[] b, int shift, int mask){
    this.count=count;
    this.start=start;
    this.shift=shift;
    this.mask=mask;
		this.slutt=slutt;
    this.a=a;
    this.b=b;
  }
  public void run(){
    int acumVal=0, j;
    for (int i =start; i <slutt; i++) { //b finn allcount
			count[(a[i]>>> shift) & mask]++;
		}






    // for (int i =0; i <=mask; i++){ //c
		// 	j = count[i];
		// 	count[i] = acumVal;
		// 	acumVal += j;
		// }
    // for (int i = start; i < slutt; i++) { //D
    //   b[count[(a[i]>>>shift) & mask]++] = a[i];
    // }

  }
}

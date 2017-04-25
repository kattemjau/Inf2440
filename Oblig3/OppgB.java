class OppgB extends Thread{
  int start, slutt, shift, mask;
  int[] count, a;
  int[][] b;
  int index;


  public OppgB(int index, int start, int slutt, int[] a, int[][] b, int shift, int mask){
    // this.count=count;
    this.index=index;
    this.start=start;
    count = new int[mask+1];
    this.shift=shift;
    this.mask=mask;
    this.slutt=slutt;
    this.a=a;
    this.b=b;
  }
  public void run(){
    // System.out.println("index " + index);
    int acumVal=0, j;
    // System.out.println("Mask:" + mask + ", skift: " + shift);

    for (int i =start; i <slutt; i++) { //b finn allcount
      count[(a[i]>>> shift) & mask]++;

    }
    for (int i = 0; i <= mask; i++){
			j = count[i];
			count[i] = acumVal;
			acumVal += j;
		}
    for (int i=0;i<count.length ;i++ ) {
      b[index][i]=count[i];
      // allcount[count[i]]++;
    }

    // synkronisering


    //telle opp hvor mange plasser før denne == startplass

    // oppg D felles
    for (int i = start; i < slutt; i++) {
				b[count[(a[i]>>>shift) & mask]++] = a[i];
		}

    // Sette sammen deler fra D



    // for (int i = 0; i < count.length; i++) {
    //   System.out.print(count[i] + " y ");

    // }




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

class OppgA extends Thread{
  int start, slutt;
  int[] a;
  int max=0;

  public OppgA(int start, int slutt, int[] a){
    this.a=a;
    this.start=start;
		this.slutt=slutt;
  }
  public void run(){
    for (int i = start ; i < slutt ; i++)
      if (a[i] > max) max = a[i];

  }
}

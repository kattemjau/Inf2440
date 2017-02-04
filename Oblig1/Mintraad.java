class Mintraad extends Thread{
  int[] array;

  Mintraad(int[] array){
    this.array=array;
  }

  public void run(){
    System.out.println("runnning");
    
    /*
    static int[] sorterOppg(){
    }

    static int[] swap(int[] array, pos1, pos2){
      int temp = array[pos1];
      array[pos1]=array[pos2];
      array[pos2]=temp;
      return array;
    } */
  }

}

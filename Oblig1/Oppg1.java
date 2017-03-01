import java.util.*;


public class Oppg1{
  public static void main(String[] args) {
    int[] array;
    try{
      // n er n svar pa soket
      String b = args[0];
      // k er de storste tallene
      String h = args[1];
      int k = Integer.parseInt(h);
      int n = Integer.parseInt(b);
      System.out.println("K: " + k + " N: " + n);
      if(k>n){
        System.out.println("bruh feil verdier");
        System.exit(1);
      }
      array = oprettArray(n);

      for (int y=0; y<7 ;y++ ) {
        // new Handler(Arrays.copyOf(array, array.length), k).arraySort();
        // new Handler(Arrays.copyOf(array, array.length), k).sekv();
        new Handler(Arrays.copyOf(array, array.length), k).parralelisering();
      }


    }catch(Exception e){
      e.printStackTrace();
      System.out.println("Wrong args!");
      System.out.println("Run the program with the following statements!");
      System.out.println("java (allocate max ram) oppg1.java 'N' 'K' ");
      System.exit(1);
    }

    // print(array);


  }

  // creates the random array
  static int[] oprettArray(int number){
    int array[]=new int[number];
    Random rand = new Random(number);

    for (int i =0;i<number ;i++ ) {
      array[i]=rand.nextInt(number);
    }
    return array;

  }




}

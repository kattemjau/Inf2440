import java.util.Random;


public class oppg1{


  public static void main(String[] args) {
    int number =0;
    try{
      String input = args[0];
      number = Integer.parseInt(input);
    }catch(Exception e){
      System.out.println("Wrong args!");
      System.out.println("Run the program with the following statements!");
      System.out.println("java (allocate max ram) oppg1.java 'random number'");
      System.exit(1);
    }
    int[] array = oprettArray(number);

    Mintraad traad = new Mintraad(array);
    traad.start();
    // print(array);


  }

  // creates the random array
  static int[] oprettArray(int number){
    int array[]=new int[number];
    Random rand = new Random();

    for (int i =0;i<number ;i++ ) {
      array[i]=rand.nextInt(number);
    }
    return array;

  }

  //prints the random array
  static void print(int[] array){
    for (Integer i: array ) {
      System.out.println(i);
    }
  }






}

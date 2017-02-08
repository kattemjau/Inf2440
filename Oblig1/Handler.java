import java.util.concurrent.*;
class Handler{
	int[] nyArray;


	CyclicBarrier barrier = new CyclicBarrier(1);

	int[] run(int[] array){
		try{
			Mintraad traad = new Mintraad(array, this, 0, array.length, 10);
			traad.start();
			nyArray = new int[array.length];
			barrier.await();
			// System.out.println("No error");
		}catch(Exception e){
			System.out.println("error running thread");
		}

		return nyArray;
	}
	synchronized void synkroniserArray(int[] array, int start, int slutt) {
		for (int i=start+1; i<slutt; i++) {
			nyArray[i]=array[i];

		}
	}
}

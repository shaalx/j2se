package queue;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class QUEUE {
	public static void main(String[] args) {
//		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(5);
//		BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>(5);
		BlockingQueue<Integer> bq = new PriorityBlockingQueue<>(5, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
//		BlockingQueue<Integer> bq = new SynchronousQueue<Integer>();
		new Thread(new ProductThread(bq)).start();
		new Thread(new ProductThread(bq)).start();
		new Thread(new ConsumeThread(bq)).start();
		
	}
}

class ProductThread extends Thread{
	BlockingQueue<Integer> queue;
	static Random random = new Random(100);
	public ProductThread(BlockingQueue<Integer> bq){
		queue = bq;
	}
	@Override
	public void run() {
		try {
			while (true) {
				Integer item = randomInt();
				queue.put(item);
				Thread.sleep(1000);
				System.out.println("put: "+item);	
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized static int randomInt(){
		return random.nextInt(100);
	}
}

class ConsumeThread extends Thread{
	BlockingQueue<Integer> queue;
	public ConsumeThread(BlockingQueue<Integer> bq){
		queue = bq;
	}
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(2000);
				Integer item = (Integer)(queue.take());
				System.out.println("take: "+item);	
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
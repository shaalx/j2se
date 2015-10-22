package sema;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Semaphore sema_c = new Semaphore(3);
		Semaphore sema_p = new Semaphore(3);
		for(int i=0;i<3;i++){
			sema_c.acquire();
		}
		Random random = new Random();
		BlockingQueue<Resource> res = new LinkedBlockingQueue<>();
		
		new Thread(new Product(res, sema_c, sema_p, random)).start();
		new Thread(new Product(res, sema_c, sema_p, random)).start();
		new Thread(new Consume(res,sema_c,sema_p)).start();
		new Thread(new Consume(res,sema_c,sema_p)).start();
		new Thread(new Travel(res)).start();
	}
}

class Resource{
	int Num;
	public Resource(int n) {
		Num = n;
	}
}

class Consume implements Runnable{
	Semaphore sema_c;
	Semaphore sema_p;
	BlockingQueue<Resource> data;
	public Consume( BlockingQueue<Resource> res,Semaphore sema_c, Semaphore sema_p) {
		this.sema_c = sema_c;
		this.sema_p = sema_p;
		this.data = res;
	}
	@Override
	public void run() {
		Resource resource;
		try {
			while (true) {
				sema_c.acquire();
				resource = data.take();
				System.out.println(resource.Num+" is taken..");
				sema_p.release();
				Thread.sleep(1500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class Product implements Runnable{
	BlockingQueue<Resource> data;
	Semaphore sema_c;
	Semaphore sema_p;
	Random rand;
	public Product(BlockingQueue<Resource> res, Semaphore c,Semaphore p,Random r) {
		data = res;
		sema_c = c;
		sema_p = p;
		rand = r;
	}
	@Override
	public void run() {
		try {
			while(true){
				Thread.sleep(1000);
				sema_p.acquire();
				int n = rand.nextInt(100);
				data.put(new Resource(n));
				System.out.println(n+" is produced.");
				sema_c.release();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Travel implements Runnable{
	BlockingQueue<Resource> res;
	public Travel(BlockingQueue<Resource> r) {
		res = r;
	}
	@Override
	public void run() {
		while(true){
			try {
				for(Resource r:res){
					System.out.print(r.Num+"--");
				}
				System.out.println();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


package executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Exc {
	public static void main(String[] args) {
		//Executor exc = Executors.newCachedThreadPool();
		//Executor exc = Executors.newSingleThreadExecutor();
		//Executor exc = Executors.newFixedThreadPool(2);
		Executor exc = Executors.newScheduledThreadPool(2);
		exc.execute(new Schedule("one"));
		exc.execute(new Schedule("two"));
		exc.execute(new Schedule("three"));
	}
}

class Schedule implements Runnable{
	String name;
	public Schedule(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		try{
			int k=0;
			while(k++<5){
				Thread.sleep(1000);
				System.out.println(name+" schedule..");
			}
		}catch(Exception e){}
	}
	
}

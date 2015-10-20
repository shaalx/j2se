package executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Exc {
	public static void main(String[] args) {
		Executor exc = Executors.newCachedThreadPool();
		exc.execute(new Schedule("one"));
		exc.execute(new Schedule("two"));
	}
}

class Schedule implements Runnable{
	String name;
	public Schedule(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name+" schedule..");
	}
	
}

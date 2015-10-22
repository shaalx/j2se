package atomic;

import java.util.concurrent.atomic.AtomicReference;

public class Main {
	public static void main(String[] args) {
		Data d = new Data("default",0);
		AtomicReference<Data> refd = new AtomicReference<Data>(d);
		Data d2 = new Data("default",0);
		Data updated = new Data("update",1);
		refd.compareAndSet(d2, updated);// use == not equals
		Data gd = refd.get();
		System.out.println(gd.Name);
	}
}

class Data{
	String Name;
	int id;
	public Data(String name, int id) {
		super();
		Name = name;
		this.id = id;
	}
	public boolean equals(Data d) {
		if (Name.equals(d.Name)&&id==d.id) {
			return true;
		}
		return false;
	}
}


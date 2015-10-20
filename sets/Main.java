package sets;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Set<Per> s = new HashSet<Per>();
		Per p1 = new Per("one", 1);
		Per p2 = new Per("two", 2);
		Per p3 = new Per("three", 3);
		s.add(p1);
		s.add(p2);
		s.add(p3);
		main.travel(s);
		p3.Age = 33;
		main.travel(s);
		
		boolean ok = s.remove(p3);
		System.out.println(ok);
		main.travel(s);
		s.add(p3);
		main.travel(s);
	}
	
	public void travel(Set<Per> s) {
		System.out.println("\n#############################");
		for(Per sPer : s){
			System.out.printf("name:%s, age:%d\n", sPer.Name,sPer.Age);
		}
		System.out.println("\n#############################¡¢");
	}
}

class Per{
	String Name;
	int Age;
	public Per(String n, int a) {
		Name = n;
		Age = a;
	}
}
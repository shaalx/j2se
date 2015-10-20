package baseral;

abstract class Animal{
	public String name="Animal";
	public void bite(){
		System.out.println(name+" bite..");
	}
}

class Dog extends Animal{
	public String name ="Dog";
	public void bite() {
		System.out.println(name+" override bite..");
	}
}

public class base{
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.bite();
		
		animal = new Animal() {
			
		};
		animal.bite();
	}
}

interface base1 {
	public void do1();
}

interface base2 extends base1{
	public void do2();
}

class cbase implements base2{

	@Override
	public void do1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void do2() {
		// TODO Auto-generated method stub
		
	}
	
	
}
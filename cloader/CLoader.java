package cloader;

public class CLoader {
	public static void main(String[] args) {
		try {
			Animal animal = (Animal)(Class.forName("cloader.Dog").newInstance());
			animal.Bite();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
abstract class Animal{
	public void Bite() {
		
	}
}
class Dog extends Animal{
	public void Bite() {
		System.out.println("dog bite..");
	}
}
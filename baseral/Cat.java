package baseral;

abstract class Animalq{
    abstract void say();
}
public class Cat extends Animalq{
    public Cat(){
        System.out.printf("I am a cat");
    }
    public static void main(String[] args) {
        Cat cat=new Cat();
    }
	@Override
	void say() {
		// TODO Auto-generated method stub
		
	}
}
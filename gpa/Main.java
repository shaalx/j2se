package gpa;

public class Main {
	public static void main(String[] args) {
		int i=2;
		i = i++ + ++i + i++;
		System.out.println(i);	
		// 10
	}
}

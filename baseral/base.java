package baseral;

public interface base {
	public void do1();
}

interface base2 extends base{
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
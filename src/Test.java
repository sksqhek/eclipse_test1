public class Test {
	
	static public void main(String args[])
	{		
		Sandwitch s = new Sandwitch();
		
		System.out.println(s.amount);
		System.out.println(s.TYPE);
	}
}

interface Edible {

    boolean amount=true;

    final int TYPE = 10;

    public void eat();   

};

class Sandwitch implements Edible {

    public void eat() { }

} 




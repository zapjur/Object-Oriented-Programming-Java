
public class TestClass {
	
	private static int id = 0;
	private long ms = 0;
	
	public TestClass() {
		this.id++;
		this.ms = System.currentTimeMillis();
	}
	
	public String toString() {
		return this.id + ". " + "[" + this.ms + "]"; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length == 0) System.out.println("Brak argumentów programu.");
		else {
			int ammount = Integer.parseInt(args[0]);
			for(int i = 0; i < ammount; i++) {
				TestClass test = new TestClass();
				System.out.println(test.toString());
			}
			System.out.println("Liczba obiektów: " + ammount);
		}

	}

}

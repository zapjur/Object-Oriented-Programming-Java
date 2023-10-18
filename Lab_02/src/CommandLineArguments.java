
public class CommandLineArguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length > 0) {
			System.out.println("Liczba argumentow: " + args.length);
			for(int i=0; i<args.length; i++) {
					System.out.println((i+1) + ". " + args[i]);
			}
		}
		else {
			System.out.println("Brak argumentow programu");
		}
	}

}

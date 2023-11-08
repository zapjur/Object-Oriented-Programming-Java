import java.util.Scanner;

public class DrawSquare {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("Podaj długość boku kwadratu: ");
			int sideLength = scanner.nextInt();
			
			if(sideLength <= 0) {
				System.out.println("Długość boku musi być dodatnia i większa od 0.");
				return;
			}
			
			drawSquare(sideLength);
			
		}
		catch(Exception e) {
			System.out.println("Wystąpił błąd, upewnij się że podałeś poprawną liczbe.");
			return;
		}
		finally {
			scanner.close();
		}
	}
	
	private static void drawSquare(int sideLength) {
		for(int i = 1; i <= sideLength; i++) {
			for(int j = 1; j <= sideLength; j++) {
				if(i == 1 || i == sideLength || j == 1 || j == sideLength) {
					System.out.print("#");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}

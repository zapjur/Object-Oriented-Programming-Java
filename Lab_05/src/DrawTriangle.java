import java.util.Scanner;

public class DrawTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("Podaj wysokość trójkąta: ");
			int height = scanner.nextInt();
			
			if(height < 2 && height >= 0) {
				System.out.println("Wysokość nie może być mniejsza od 2");
				return;
			}
			else if(height < 0) {
				System.out.println("Wysokość nie może być ujemna");
				return;
			}
			
			drawTriangle(height);
		}
		catch(Exception e) {
			System.out.println("Wystąpił błąd, upewnij się że podałeś poprawną liczbe.");
			return;
		}
		finally {
			scanner.close();
		}

	}
	
	private static void drawTriangle(int height) {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < height - i - 1; j++)
				System.out.print(" ");
			
			for(int k = 0; k < 2 * i + 1; k++)
				System.out.print("#");
			
			for(int j = 0; j < height - i - 1; j++)
				System.out.print(" ");
				
			System.out.println();
		}
	}

}

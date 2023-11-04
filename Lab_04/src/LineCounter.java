import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
public class LineCounter {

	private static int lineCount = 0;
	
	public static void readLines(String fileName) {
		
		
		try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
		
			while((file.readLine()) != null) {
					lineCount++;
				}
			
			System.out.println("Liczba wierszy w pliku " + fileName + " wynosi: " + lineCount);
			
		}
		catch(FileNotFoundException e) {
			String[] text = e.getMessage().split(" ");
			System.out.println("Plik " + text[0] + " nie istnieje.");
			return;
		}
		catch (Exception e){
			System.out.println("Wystąpił błąd podczas czytania pliku");
			return;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			readLines(args[0]);
		}
		catch(Exception e) {
			System.out.println("Brak argumentów programu.");
			System.exit(0);
		}
		
	}

}

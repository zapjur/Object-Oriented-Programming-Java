import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class WordCounter {
	
	private static boolean countLines = false;
	private static boolean countCharacters = false;
	private static boolean countWords = false;
	
	private static int lineCount = 0;
	private static int charCount = 0;
	private static int wordCount = 0;
	
	private static String fileName = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length == 0) {
			System.out.println("Brak argumentów programu");
			System.exit(0);
		}
		
		
		try {
			readCommandLineArgs(args);
		}
		catch(Exception e) {
			System.out.println("Wystąpił błąd podczas czytania argumentów programu.");
			System.exit(0);
		}
		
		counter();
		
		if(countLines) {
			System.out.println("wierszy: " + lineCount);
		}
		if(countCharacters) {
			System.out.println("znaków: " + charCount);
		}
		if(countWords) {
			System.out.println("słów: " + wordCount);
		}
		
	}
	
	public static void counter() {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			String line;
			while((line = reader.readLine()) != null) {
				if(countLines) lineCount++;
				if(countCharacters) { 
					charCount += line.length();
				}
				if(countWords) {
					String[] words = line.split("\\s+");
					wordCount += words.length;
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Plik " + fileName + " nie istnieje.");
			System.exit(0);
		}
		catch(Exception e) {
			System.out.println("Wystąpił błąd podczas czytania pliku: " + fileName);
			System.exit(0);
		}
	}
	

	
	public static void readCommandLineArgs(String[] args) {
		
		boolean fileFound = false;
		
		for(String arg : args) {
			if(arg.startsWith("-")) {
				for(char option : arg.substring(1).toCharArray()) {
					if(option == 'l') countLines = true;
					else if(option == 'c') countCharacters = true;
					else if(option == 'w') countWords = true;
					else {
						System.out.println("Nieznana opcja: " + option);
						System.exit(0);
					}
				}
			}
			else {
				fileName = arg;
				fileFound = true;
			}
		}
		
		if(!fileFound) {
			System.out.println("Brak nazwy pliku.");
			System.exit(0);
		}
		
		
		
	}

}

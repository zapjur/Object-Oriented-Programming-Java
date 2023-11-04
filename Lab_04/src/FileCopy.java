import java.io.*;
import java.nio.file.AccessDeniedException;

public class FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length != 2) {
			System.out.println("Brak argumentów programu");
			return;
		}

		copy(args[0], args[1]);
		
	}
	
	public static void copy(String sourceFileName, String targetFileName) {
		File sourceFile;
		File targetFile;
		
		try {
			sourceFile = new File(sourceFileName);
			
			
			if(sourceFile.isDirectory()) {
				System.out.println("Plik " + sourceFileName + " jest katalogiem");
				return;
			}
			
			targetFile = new File(targetFileName);
			
			if(!targetFile.exists()) {
				boolean created = targetFile.createNewFile();
				if(!created) {
					System.out.println("Nie udało się utworzyć pliku " + targetFileName);
					return;
				}
			}
			else if(targetFile.isDirectory()) {
				targetFile = new File(targetFile, sourceFileName);
				boolean created = targetFile.createNewFile();
				if(!created) {
					System.out.println("Nie udało się utworzyć pliku " + targetFileName);
					return;
				}
			}
		
		
			try (InputStream inStream = new FileInputStream(sourceFile);
				 OutputStream outStream = new FileOutputStream(targetFile)){
					
					byte[] buffer = new byte[4096];
					int bytesRead;
					
					while((bytesRead = inStream.read(buffer)) != -1) {
						outStream.write(buffer, 0, bytesRead);
					}
			}
			catch(FileNotFoundException e){
				String[] text = e.getMessage().split(" ");
				System.out.println("Plik " + text[0] + " nie istnieje");
				return;
			}
			catch(AccessDeniedException e) {
				String[] text = e.getMessage().split(" ");
				System.out.println("Brak Wymaganych uprawnień do zapisu pliku " + text[0]);
				return;
			}
			catch(IOException e) {
				String[] text = e.getMessage().split(" ");
				System.out.println("Nie można nadpisać pliku " + text[0]);
				return;
			}	
			
		}
		catch(IOException e) {
			String[] text = e.getMessage().split(" ");
			System.out.println("Wystąpił błąd przy operacji na pliku " + text[0]);
			return;
		}
		
	}
}



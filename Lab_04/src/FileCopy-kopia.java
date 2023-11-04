import java.io.*;

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
		try {
			File sourceFile = new File(sourceFileName);
			
			if(!sourceFile.exists()) {
				System.out.println("Plik " + sourceFileName + " nie istnieje.");
				return;
			}
			
			if(sourceFile.isDirectory()) {
				System.out.println(sourceFileName + " jest katalogiem.");
				return;
			}
			
			if(!sourceFile.canRead()) {
				System.out.println("Brak dostępu do pliku " + sourceFileName);
				return;
			}
			
			File targetFile = new File(targetFileName);
			
			if(!targetFile.exists()) {
				boolean created = targetFile.createNewFile();
				if(!created) {
					System.out.println("Nie udało się utworzyć pliku " + targetFileName);
					return;
				}
			}
			
			if(!targetFile.isDirectory()) {
				if(!targetFile.canWrite()) {
					System.out.println("Brak wymaganych uprawnień do zapisu pliku " + targetFileName);
					return;
				}

			}
			else {
				if(!targetFile.canWrite()) {
					System.out.println("Brak wymaganych uprawnień katalogu " + targetFileName);
					return;
				}
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
				
				return;
			}
			catch(IOException e) {
				System.out.println("Wystąpił błąd podczas kopiowania pliku.");
				return;
			}
			
			
			
		}
		catch(IOException e) {
			System.out.println("Wystąpił błąd podczas obsługi plików");
			return;
		}
	}

}

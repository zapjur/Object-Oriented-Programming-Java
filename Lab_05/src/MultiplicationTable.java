import java.io.*;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;


public class MultiplicationTable {

	private static Properties properties = new Properties();
	
	public MultiplicationTable() {
		try(FileInputStream input = (new FileInputStream("settings.properties"))){
			properties.load(input);
		}
		catch(IOException e) {
			try(FileOutputStream output = new FileOutputStream("settings.properties")){
				properties.setProperty("wartosc_minimum", "1");
                properties.setProperty("wartosc_maximum", "10");
                properties.setProperty("powtorzen_minimum", "10");
                properties.setProperty("powtorzen_maximum", "25");
                properties.setProperty("procent", "0.7");
                properties.store(output, null);
			}
			catch(IOException e1) {
				System.out.println(e1.getMessage());
				System.exit(0);
			}
		}
	}
	
	public static int getMinValue() {
        return Integer.parseInt(properties.getProperty("wartosc_minimum"));
    }

    public static int getMaxValue() {
        return Integer.parseInt(properties.getProperty("wartosc_maximum"));
    }

    public static float getPercentage() {
        return Float.parseFloat(properties.getProperty("procent"));
    }

    public static int getMinRepetitions() {
        return Integer.parseInt(properties.getProperty("powtorzen_minimum"));
    }

    public static int getMaxRepetitions() {
        return Integer.parseInt(properties.getProperty("powtorzen_maximum"));
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplicationTable table = new MultiplicationTable();
		Random generator = new Random();
		Scanner scanner = new Scanner(System.in);
		int round = 0, correctAns = 0;
	
		while(round < table.getMaxRepetitions()) {
			System.out.println("Round number: " + ++round);
			int n1 = generator.nextInt(table.getMinValue(), table.getMaxValue());
			int n2 = generator.nextInt(table.getMinValue(), table.getMaxValue());
			System.out.print(n1 + " * " + n2 + " = ");
			int ans = 0;
			try {
				ans = scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Wrong input");
				System.exit(0);
			}
			if(ans == n1*n2) {
				correctAns++;
			}
			if(((float)correctAns / round) >= table.getPercentage() && round >= 10) {
				System.out.println("You won in " + round + " round!");
				System.out.println("Your score: " + ((float)correctAns/round) * 100 + "%");
				System.exit(0);
			}
		}
		
		System.out.println("You lose! Your Score: " + ((float)correctAns/round) * 100 + "%");
	}

}

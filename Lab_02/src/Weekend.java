import java.util.Date;

public class Weekend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		int daysToWeekend = 5 - date.getDay();
		if(daysToWeekend <= 0) {
			System.out.println("Jest weekend");
		}
		else {
			System.out.println("Liczba dni do weekendu: " + daysToWeekend);	
		}
	}
}

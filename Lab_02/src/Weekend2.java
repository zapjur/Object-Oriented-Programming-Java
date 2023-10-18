import java.util.Calendar;


public class Weekend2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar calendar = Calendar.getInstance();
		String days[] = {"Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota"};  
		int today = calendar.get(Calendar.DAY_OF_WEEK);
		int daysToWeekend = 6 - today;
		switch (today) {
			case 2:
			case 3:
			case 4:		
				System.out.println("Dziś " + days[today - 1] + ", do weekendu pozostały: " +daysToWeekend+ " dni");
				break;
		
			case 5:
				System.out.println("Dziś " + days[today - 1] + ", do weekendu pozostał: " +daysToWeekend+ " dni");
				break;
				
			case 6:
				System.out.println("Dziś " + days[today - 1] + ", do weekendu pozostało: " +daysToWeekend+ " dni");
				break;
				
			default:
				System.out.println("Mamy weekend!");
				break;
		}
	}

}

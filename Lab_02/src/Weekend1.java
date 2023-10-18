import java.util.Date;

public class Weekend1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
		int today = date.getDay();
		
		switch(today) {
			case 1:
				System.out.println("Poniedziałek");
				break;
			
			case 2:
				System.out.println("Wtorek");
				break;
			
			case 3:
				System.out.println("Środa");
				break;
		
			case 4:
				System.out.println("Czwartek");
				break;
			
			case 5:
				System.out.println("Piatek");
				break;
			
			default:
				System.out.println("Weekend");
				break;
			
		}
	}

}

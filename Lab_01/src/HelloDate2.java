import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloDate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		String dateFormatted = format.format(date);
		System.out.println("Witaj! Teraz jest: " + dateFormatted);

	}

}

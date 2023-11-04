import javax.swing.JOptionPane;
public class LineCounterPane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = JOptionPane.showInputDialog("Podaj nazwe pliku");
		LineCounter.readLines(fileName);

	}

}


public class FloatArithmeticMean {


    public static void main(String[] args) {
        String message = (args.length == 0) ? "Brak argumentów programu" :
                         (args.length == 1) ? "Przekazano tylko jedną wartość: " + args[0] :
                         finalMessage(args);

        System.out.println(message);
    }

    private static String finalMessage(String[] args) {
        String finalMessage = "";
    	float sum = 0;
    	for(String arg : args) {
    		float num = Float.parseFloat(arg);
    		sum += num;
    		finalMessage += String.format("%.3f", num) + "\n";
    		
    	}
    	float mean = sum / args.length;
    	
    	finalMessage += "---------- \n" + String.format("%.3f", sum) + "\n";
    	finalMessage += "Średnia arytmetyczna: " + String.format("%.4f", mean);
    	
        
        return finalMessage;
       
    }
    
}

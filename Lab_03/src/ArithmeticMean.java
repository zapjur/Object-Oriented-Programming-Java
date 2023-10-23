public class ArithmeticMean {

    public static void main(String[] args) {
        String message = (args.length == 0) ? "Brak argumentów programu" :
                         (args.length == 1) ? "Przekazano tylko jedną wartość: " + args[0] :
                         meanMessage(args);

        System.out.println(message);
    }

    private static String meanMessage(String[] args) {
        int sum = 0;
        String nums = "";
        for (String arg : args) {
            sum += Integer.parseInt(arg);
            nums += arg + ", ";
        }
        int mean = sum / args.length;
        int rest = sum % args.length;

        return (rest == 0) ? "Średnia arytmetyczna liczb: " + nums + "wynosi: " + mean :
                             "Średnia arytmetyczna liczb: " + nums + "wynosi: " + mean + ", reszta: " + rest;
    }
}


package task;

public class Application {
    private static StringFromNumber stringFromNumber = new StringFromNumber();
    private static Reader reader = new Reader();

    public static void main(String[] args) {
        String number = reader.readNumberFromFile();
        System.out.println("Number was read: " + number + "\n\n");


        String numberAsString = stringFromNumber.numberToString(Long.parseLong(number));
        System.out.println("Result:\n" + numberAsString);


    }
}

package task;


public class Application {
    private static StringFromNumber stringFromNumber = new StringFromNumber();
    private static Reader reader = new Reader();

    public static void main(String[] args) {
        long number = reader.readNumberFromFile();
        System.out.println("Number was read from degree: " + number + "\n\n");

        String[][] degree = reader.readDegree();

        String numberAsString = stringFromNumber.numberToString(number, degree);
        System.out.println("Result:\n" + numberAsString);
    }
}

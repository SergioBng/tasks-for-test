package task;

public class Application {
    private static StringFromNumber stringFromNumber = new StringFromNumber(12417342);

    public static void main(String[] args) {
        String numberAsString = stringFromNumber.numberToString();
        System.out.println(numberAsString);
    }
}

package task;

import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public Reader() {
    }

    public String readNumberFromFile() {
        String numberInString = "";
        try(FileReader reader = new FileReader("C:\\Users\\user\\Desktop\\dev\\tasks-for-test\\src\\task" +
                "\\resource\\number")) {
             int c;
             while ((c = reader.read()) != -1) {
                 numberInString += (char)c;
             }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return numberInString;
    }

    public String[][] readDegree() {
        String numberInString = "";
        try(FileReader reader = new FileReader("C:\\Users\\user\\Desktop\\dev\\tasks-for-test\\src\\task" +
                "\\resource\\degree")) {
            int c;
            while ((c = reader.read() ) != -1) {
                numberInString += (char)c;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return addDegreesInArray(numberInString);
    }

    public static String[][] addDegreesInArray(String numberInString) {
        String[] formWithoutDegree = {"", "", "", "0"};

        String[] arrayOfDegrees = numberInString.split(" ");
        String[][] formats = new String[(arrayOfDegrees.length / 4) + 1][4];

        for (int i = 0; i < 4; i++) {
            formats[0][i] = formWithoutDegree[i];
        }

        int k = 0;
        for (int i = 1; i < (arrayOfDegrees.length / 4) + 1; i++) {
            for(int j = 0; j < 4; j++) {
                formats[i][j] = arrayOfDegrees[k++];
            }
        }
        return formats;
    }
}

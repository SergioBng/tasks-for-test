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
}

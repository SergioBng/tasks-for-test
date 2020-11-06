package task;

import java.util.ArrayList;
import java.util.Collections;

public class StringFromNumber {
private long numberForChange;

    public StringFromNumber() {
        this.numberForChange = numberForChange;
    }

    public String numberToString(long numberForChange) {
        // necessary words for creating right form of final number
        String[][] str1 = {
                {"","один","два","три","четыре","пять","шесть","семь","восемь","девять"},
                {"","одна","две","три","четыре","пять","шесть","семь","восемь","девять"},
        };
        String[] str100= {"","сто","двести","триста","четыреста","пятьсот","шестьсот",
                "семьсот", "восемьсот","девятьсот"};

        String[] str11 = {"","десять","одиннадцать","двенадцать","тринадцать","четырнадцать", "пятнадцать",
                "шестнадцать","семнадцать","восемнадцать","девятнадцать","двадцать"};

        String[] str10 = {"","десять","двадцать","тридцать","сорок","пятьдесят","шестьдесят", "семьдесят",
                "восемьдесят","девяносто"};

        String[][] forms = {
                {"", "", "", "0"},
                {"тысяча", "тысячи", "тысяч", "1"},
                {"миллион", "миллиона", "миллионов", "0"},
                {"миллиард","миллиарда","миллиардов","0"},
                {"триллион","триллиона","триллионов","0"},
        };

        // splitting number on segments
        ArrayList segments = new ArrayList();
        while(numberForChange > 999) {
            long seg = numberForChange / 1000;
            segments.add(numberForChange - (seg * 1000));
            numberForChange = seg;
        }

        segments.add(numberForChange);
        Collections.reverse(segments);

        // check on zero
        String stringWithNumber = "";
        if (numberForChange == 0) {
            stringWithNumber = "ноль";
        }

        int lev = segments.size() - 1;
        for (int i = 0; i <segments.size(); i++) {// sorting segments
            int selectForm = Integer.valueOf(forms[lev][3]);//  definition of sort
            int currentSegment = Integer.valueOf(segments.get(i).toString());
            if (currentSegment == 0 && lev > 1) {// if segment == 0 and not last level(there Unit)
                lev--;
                continue;
            }

            String currentSegmentAsString = String.valueOf(currentSegment); // number in string

            // normalization
            // two zero in prefix?
            if (currentSegmentAsString.length() == 1) currentSegmentAsString = "00" + currentSegmentAsString;
            // or one?
            if (currentSegmentAsString.length() == 2) currentSegmentAsString = "0" + currentSegmentAsString;
            // get numbers for analysis
            int r1 = Integer.valueOf(currentSegmentAsString.substring(0, 1)); //first number
            int r2 = Integer.valueOf(currentSegmentAsString.substring(1, 2)); //second number
            int r3 = Integer.valueOf(currentSegmentAsString.substring(2, 3)); //third number
            int r22= Integer.valueOf(currentSegmentAsString.substring(1, 3)); //second and third
            // analyse numbers
            if (currentSegment > 99) stringWithNumber += str100[r1] + " "; // hundreds
            if (r22 > 20) {// >20
                stringWithNumber += str10[r2] + " ";
                stringWithNumber += str1[selectForm][r3] + " ";
            }
            else { // <=20
                if (r22 > 9) stringWithNumber += str11[r22-9] + " "; // 10-20
                else stringWithNumber += str1[ selectForm ][r3] + " "; // 0-9
            }

            stringWithNumber += morph(currentSegment, forms[lev][0], forms[lev][1], forms[lev][2]) + " ";
            lev--;
        }
        return stringWithNumber;
    }

    public static String morph(long n, String f1, String f2, String f5) {
        n = Math.abs(n) % 100;
        long n1 = n % 10;
        if (n > 10 && n < 20) return f5;
        if (n1 > 1 && n1 < 5) return f2;
        if (n1 == 1) return f1;
        return f5;
    }
}

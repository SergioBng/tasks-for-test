package task;

import java.util.ArrayList;
import java.util.Collections;

public class StringFromNumber {
private int numberForChange;

    public StringFromNumber() {
    }

    public StringFromNumber(int numberForChange) {
        this.numberForChange = numberForChange;
    }

    public void numberToString(int numberForChange) {
        // necessary words for creating right form of final number
        String[][] str1 = {
                {"","один","два","три","четыре","пять","шесть","семь","восемь","девять"},
                {"","одна","две","три","четыре","пять","шесть","семь","восемь","девять"},
        };
        String[] str100= {"","сто","двести","триста","четыреста","пятьсот","шестьсот","семьсот", "восемьсот","девятьсот"};
        String[] str11 = {"","десять","одиннадцать","двенадцать","тринадцать","четырнадцать", "пятнадцать","шестнадцать","семнадцать","восемнадцать","девятнадцать","двадцать"};
        String[] str10 = {"","десять","двадцать","тридцать","сорок","пятьдесят","шестьдесят", "семьдесят","восемьдесят","девяносто"};
        String[][] forms = {
                {"тысяча", "тысячи", "тысяч", "1"},
                {"миллион", "миллиона", "миллионов", "0"},
                {"миллиард","миллиарда","миллиардов","0"},
                {"триллион","триллиона","триллионов","0"},
        };

        // splitting number on segments
        ArrayList segments = new ArrayList();
        while(numberForChange > 999) {
            int seg = numberForChange / 1000;
            segments.add(numberForChange - (seg * 1000));
            numberForChange = seg;
        }

        segments.add(numberForChange);
        Collections.reverse(segments);

        for(Object item: segments){
            System.out.println(item);
        }
    }
}

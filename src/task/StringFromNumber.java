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

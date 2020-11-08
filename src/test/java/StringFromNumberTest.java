import org.junit.Before;
import org.junit.Test;
import task.Reader;
import task.StringFromNumber;

import static org.junit.Assert.*;

public class StringFromNumberTest {
    private StringFromNumber stringFromNumber = new StringFromNumber();
    private Reader reader = new Reader();

    private long value1;
    private long value2;
    private long value3;

    private String string1;
    private String string2;
    private String string3;


    @Before
    public void setUp() {
        value1 = 237372;
        value2 = 123300003;
        value3 = 0;

        string1 = "двести тридцать семь тысяч триста семьдесят два";
        string2 = "сто двадцать три миллиона триста тысяч три";
        string3 = "ноль";
    }

    @Test
    public void numberToString() {
        String stringFromNumber1 = stringFromNumber.numberToString(value1, reader.readDegree());
        assertEquals(stringFromNumber1, string1);

        String stringFromNumber2 = stringFromNumber.numberToString(value2, reader.readDegree());
        assertEquals(stringFromNumber2, string2);

        String stringFromNumber3 = stringFromNumber.numberToString(value3, reader.readDegree());
        assertEquals(stringFromNumber3, string3);
    }
}
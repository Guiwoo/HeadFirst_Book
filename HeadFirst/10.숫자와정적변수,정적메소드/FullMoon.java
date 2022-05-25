import static java.lang.System.out;
import java.util.*;

public class FullMoon {
    static int DAY_IM = 1000 * 60 * 60 * 24;

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2004, 1, 7, 15, 30);
        long day1 = c.getTimeInMillis();
        day1 += (DAY_IM * 29.52);
        c.setTimeInMillis(day1);
        out.println(String.format("full moon on %tc", c));
        day1 += (DAY_IM * 29.52);
        c.setTimeInMillis(day1);
        out.println(String.format("full moon on %tc", c));
        day1 += (DAY_IM * 29.52);
        c.setTimeInMillis(day1);
        out.println(String.format("full moon on %tc", c));
    }
}

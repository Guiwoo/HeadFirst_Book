import java.util.Calendar;

public class DateCase {
    public static void main(String[] args) {
        // Calendar cal = new Calendar();
        Calendar c = Calendar.getInstance();
        // System.out.println(cal);

        c.set(2004, 0, 7, 15, 40);
        long day1 = c.getTimeInMillis();
        System.out.println(" day 1 millis " + day1);

        day1 += 1000 * 60 * 60;
        c.setTimeInMillis(day1);
        System.out.println("new hour" + c.get(c.HOUR_OF_DAY));

        c.add(c.DATE, 35);
        System.out.println("add 35days " + c.getTime());

        c.set(c.DATE, 1);
        System.out.println("set to 1 " + c.getTime());
    }
}

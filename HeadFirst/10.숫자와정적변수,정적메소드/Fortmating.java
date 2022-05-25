import java.util.Date;

public class Fortmating {
    public static void main(String[] args) {
        String s2 = String.format("%,d", ((100000000000L * 1000000L)));
        System.out.println(s2);
        // weather();
    }

    public static void nums() {
        String s = String.format("%,d", 100000000);
        System.out.println(s);
        String s2 = String.format("%,d", (1000000000000000000L));
        System.out.println(s2);
    }

    public static void weather() {
        String wholeDate = String.format("%tc", new Date());
        System.out.println(wholeDate);

        String forHour = String.format("%tr", new Date());
        System.out.println(forHour);

        Date today = new Date();
        String dayMonthDays = String.format("%tA, %tB %td", today, today, today);
        System.out.println(dayMonthDays);

        today = new Date();
        String sendOneVariable = String.format("%tA, %<tB %<td", today);
        System.out.println(sendOneVariable);
    }
}

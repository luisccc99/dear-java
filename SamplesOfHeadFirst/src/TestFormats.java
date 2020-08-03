import java.util.Calendar;
import java.util.Date;

public class TestFormats {

    public static void main(String[] args) {
        String s = String.format("%, d", 10000);
        System.out.println(s);
        String weather = String.format("I saw there is a probability of " +
                "%.2f to rain today", 76.32542);
        System.out.println(weather);
        Date today = new Date();
        System.out.println(String.format("%tA, %<tB %<td", today));
        Calendar c = Calendar.getInstance();
        c.set(2020, 6, 29, 18, 51);
        long day1 = c.getTimeInMillis();
        day1 += 1000 * 60 * 60;
        c.setTimeInMillis(day1);
        System.out.println("new hour " + c.get(c.HOUR_OF_DAY));
        c.add(c.DATE, 35);
        System.out.println("add 35 days " + c.getTime());
        c.roll(c.DATE, 35);
        System.out.println("roll 35 days " + c.getTime());
        c.set(c.DATE, 1);
        System.out.println("set to 1 " + c.getTime());
    }
}

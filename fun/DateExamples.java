import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class DateExamples {

    public static void afterTwoWeeks() {
        final Scanner sc = new Scanner(System.in);
        String inputDate = sc.next();
        sc.close();
        try {
            LocalDate afterTwoWeeks = LocalDate.parse(inputDate).plusWeeks(2);
            System.out.println(afterTwoWeeks);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void firstAndLastDayOfAMonth() {
        final Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        sc.close();
        LocalDate first = LocalDate.of(year, month, 1);
        LocalDate last = first.withDayOfMonth(first.lengthOfMonth());
        System.out.println(first + " " + last);
    }

    public static void examples() {
        // current date
        LocalDate now = LocalDate.now();
        System.out.println(now);

        // especific day of a year
        LocalDate of = LocalDate.ofYearDay(2020, 69);
        System.out.println("day 69 of 2020 ..." + of);

        // arithmetic methods
        LocalDate arithmetic = LocalDate.of(2020, 10, 17);
        LocalDate tomorrow = arithmetic.plusDays(1);
        LocalDate yesterday = arithmetic.minusDays(1);
        LocalDate inTwoYears = arithmetic.plusYears(2);
        LocalDate in2018 = arithmetic.withYear(2018);
        System.out.println("tomorrow " + tomorrow + "\nyesterday " + yesterday + "\nin two years " + inTwoYears
                + "\nin 2018" + in2018);
        System.out.println("this year is" + (arithmetic.isLeapYear() ? " " : " not ") + "a leap year");
        System.out.println("next year is" + (arithmetic.plusYears(1).isLeapYear() ? " " : " not ") + "a leap year");
    }

    public static void findAllMondays(){
        final Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        sc.close();
        LocalDate initial = LocalDate.of(year, month, 1);
        LocalDate endDate = initial.withDayOfMonth(initial.lengthOfMonth());
        for (LocalDate date = initial; date.isBefore(endDate); date = date.plusDays(1)) {
            if (date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                System.out.println(date);
            }
        }
    }

    public static void main(String[] args) {
        // DateExamples.firstAndLastDayOfAMonth();
        // DateExamples.findAllMondays();
        System.out.println(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    }

}
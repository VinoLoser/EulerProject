public class Main {
    public static void main(String[] args) {
        int [] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int previousYear = 1;
        int sundays = 0;
        boolean leapYear = false;
        for (int year = 1901; year < 2001; year++) {
            int firstDay = findFirstDay(previousYear, leapYear);
            leapYear = checkLeapYear(year);
            if (leapYear == true) {
                months[1] = 29;
            } else {
                months[1] = 28;
            }
            int date = firstDay;
            if (date%7 == 0) {
                sundays++;
            }
            date = date%7;
            previousYear = firstDay;
            for (int month = 0; month < 11; month++) {
                System.out.println("" + year + "/" + (month + 1) + " : " + date);
                date += months[month];
                date = date%7;
                sundays = checkSunday(date, month, months, sundays);
            }
        }
        System.out.println(sundays);
    }
    private static int findFirstDay(int firstDay, boolean leapYear) {
        if (leapYear == true) {
            return (firstDay + 366) % 7;
        } else {
            return (firstDay + 365) % 7;
        }
        
    }
    private static int checkSunday(int date, int month, int [] months, int sundays) {
        if (date==0) {
            sundays++;
        }
        return sundays;
    }
    private static boolean checkLeapYear(int year) {
        if (year%4 == 0 && year%100 != 0) {
            return true;
        } else {
            if (year%100 == 0 && year%400 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
package pass.Company.Optiver;

public class DaysDiff {
    static int DaysBetween(int year1, int month1, int day1, int year2, int month2, int day2) throws Exception {
        return Math.abs(date_to_int(year1, month1, day1) - date_to_int(year2, month2, day2));
    }

    public static boolean leap_year(int year){
        return ((year % 400 == 0) ||(year % 100 != 0 && year % 4 == 0));
    }
    public static int date_to_int (int year, int month, int day){
        
        int[] months = new int[]{31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int ans = 0;
        while (year != 1971 || month != 1 || day != 1){
            ans++;
            day--;
            if (day == 0){
                month--;
                if (month == 0){
                    year--;
                }
                day = months[month];
                if (month == 2 && leap_year(year)){
                    day++;
                }
            }
            if (month == 0){
                month = 12;
            }
        }
        return ans;
    }
}

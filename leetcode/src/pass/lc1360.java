package pass;

public class lc1360 {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(date_to_int(date1) - date_to_int(date2));
    }
    public boolean leap_year(int year){
        return ((year % 400 == 0) ||(year % 100 != 0 && year % 4 == 0));
    }
    public int date_to_int (String date){
        int year, month, day;
        String[] time = date.split("-");
        year = Integer.valueOf(time[0]);
        month = Integer.valueOf(time[1]);
        day = Integer.valueOf(time[2]);
        
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

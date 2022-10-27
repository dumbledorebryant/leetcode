package pass;

public class lc1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings){
            int l = booking[0] - 1;
            int r = booking[1] - 1;
            int num = booking[2];
            diff[l] += num;
            if (r + 1 < n){
                diff[r + 1] -= num;
            }
        }
        int[] ans = new int[n];
        ans[0] = diff[0];
        for (int i = 1; i < n; i++){
            ans[i] = ans[i - 1] + diff[i];
        }
        return ans;
    }
}

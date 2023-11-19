package pass;
public class lc441 {
    public int arrangeCoins(int n) {
        long l = 1;
        long r = n;

        while (l <= r){
            long mid = l + (r - l)/2;
            long num = check(mid);
            if (num < n){
                l = mid + 1;
            }
            else if (num == n){
                return (int)mid;
            }
            else {
                r = mid - 1;
            }
        }
        return (int)r;
    }

    public long check(long i){
        return i * (i + 1)/2;
    }
}

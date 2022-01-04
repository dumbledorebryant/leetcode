package pass;

public class lc793 {
    public int preimageSizeFZF(int k) {
        return (int)(rightb(k) - leftb(k) + 1);
    }
    public long leftb(int target){
        long low = 0;
        long high = Long.MAX_VALUE;
        while (low < high){
            long mid = ((high - low) >> 1) + low;
            long num = trailingZeroes(mid);
            if (num < target) {
                low = mid + 1;
            }
            else if (num > target) high = mid;
            else high = mid;
        }
        return low;
    }
    public long rightb(int target){
        long low = 0;
        long high = Long.MAX_VALUE;
        while (low < high){
            long mid = ((high - low) >> 1) + low;
            long num = trailingZeroes(mid);
            if (num < target) {
                low = mid + 1;
            }
            else if (num > target) high = mid;
            else low = mid + 1;
        }
        return low - 1;
    }

    public long trailingZeroes(long n) {
        long num = n;
        long count = 0;
        while (num > 0){
            count += (num / 5);
            num = num / 5;
        }
        return count;
    }
}

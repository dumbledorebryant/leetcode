package pass;

public class lc69 {
    public int mySqrt(int x) {
        int lo = 0;
        int hi = x;
        if (hi > 46340) hi = 46340;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            int num = (mid * mid);
            if (num > x){
                hi = mid - 1;
            }
            else if (num < x) lo = mid + 1;
            else return mid;
        }
        return hi;
    }
}

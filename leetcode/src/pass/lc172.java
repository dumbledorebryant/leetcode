package pass;

public class lc172 {
    public int trailingZeroes(int n) {
        int num = n;
        int count = 0;
        while (num > 0){
            count += (num / 5);
            num = num / 5;
        }
        return count;
    }
}

package pass;

public class lc2214 {
    public long minimumHealth(int[] damage, int armor) {
        boolean flag = false;
        long sum = 1;
        long max = 0;
        for (int num : damage){
            if (num >= armor){
                flag = true;
            }
            max = Math.max(max, num);
            sum += (long)num;
        }
        if (flag) return sum - armor;
        else return sum - max;
    }
}

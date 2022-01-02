package pass;

public class lc1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int length = chalk.length;
        long sum = 0;
        for (int i = 0; i < length; i++){
            sum += chalk[i];
        }
        int left = (int)(k % sum);
        
        for (int i = 0; i < length; i++){
            int num = chalk[i];
            if (left - num < 0) return i;
            left -= num;
        }
        return -1;
    }
}

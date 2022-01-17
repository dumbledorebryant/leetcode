package pass;

public class lc134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int total = 0;
        for (int i = 0; i < len; i++){
            total += gas[i];
            total -= cost[i];
        }
        if (total < 0) return -1;
        total = 0;
        int start = 0;
        for (int i = 0; i < len; i++){
            total += gas[i];
            total -= cost[i];
            if (total < 0){
                start = i + 1;
                total = 0;
            }
        }
        return start;
    }
}

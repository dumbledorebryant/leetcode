package pass;

import java.util.Arrays;

public class lc991 {
    public int brokenCalc(int startValue, int target) {
        if (startValue >= target) return startValue - target;
        else {
            if (target % 2 == 0) return 1 + brokenCalc(startValue, target / 2);
            else return brokenCalc(startValue, (target + 1)) + 1;
        }
    }
}

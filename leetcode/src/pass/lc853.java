package pass;
import java.util.*;
public class lc853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        double[] timeArr = new double[target];
        for (int i = 0; i < position.length; i++)
        {
            timeArr[position[i]]= (double)(target - position[i]) / speed[i];
        }
        double prev = 0.0;
        for (int i = target-1; i >=0 ; i--)
        {
            double cur = timeArr[i];
            if (cur > prev)
            {
                prev = cur;
                res++;
            }
        }
        return res;   
    }
}

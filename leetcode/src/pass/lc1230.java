package pass;

public class lc1230 {
    public double probabilityOfHeads(double[] prob, int target) {
        double res = 1.0;
        if (target == 0) {
            for (int i = 0; i < prob.length; i++) {
                res *= 1 - prob[i];
            }
            return res;
        }
        
        double[] probTarget = new double[target + 1];
        probTarget[0] = 1.0;
        
        for (int i = 0; i < prob.length; i++) {
            for (int j = target; j > 0; j--) {
                probTarget[j] = prob[i] * probTarget[j - 1]
                    + (1.0 - prob[i]) * probTarget[j];
            }
            probTarget[0] = (1.0 - prob[i]) * probTarget[0];
            
        }
        return probTarget[target];
    }
}

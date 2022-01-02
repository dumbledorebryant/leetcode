package pass;

public class lc502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int length = profits.length;
        

        
        return w;
    }

    public int bruteForceFindMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int length = profits.length;

        for (int m = 0; m < k; m++){
            int maxp = -1;
            int index = -1;
            
            for (int i = 0; i < length ; i++){
                int p = profits[i];
                
                if (w >= capital[i] && p > maxp) {
                    maxp = p;
                    index = i;
                }
            }

            if (index == -1){
                break;
            }

            w += maxp;
            capital[index] = Integer.MAX_VALUE;
        }
        return w;
    }
}

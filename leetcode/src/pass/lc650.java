package pass;

public class lc650 {
    public int minSteps(int n) {
        if (n == 1) return 0;
        if (n == 2) return 2;
        if (n == 3) return 3;

        int count = 1;
        int i = 1;
        while (i <= (n >> 2)){

        }

        return 0;
    }

    public int nextSteps(int left, int step, int onb){
        if (step == left) return 1;
        if (onb == (left >> 2)) return 2;
        
        if (left/step > left/(2 * onb) + 1){
            
        }
        return 0;
    }
}

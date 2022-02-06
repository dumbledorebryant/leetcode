package pass.weekly_contest.wc2022_02_05;


public class lc6002 {
    int[] ans;
    int len;
    int count = 0;
    boolean flip = false;
    public lc6002(int size) {
        ans = new int[size];
        len = size;
    }
    
    public void fix(int idx) {
        if (flip){
            if (ans[idx] == 1){
                ans[idx] = 0;
                count--;
            }
        }
        else {
            if (ans[idx] == 0){
                ans[idx] = 1;
                count++;
            }
        }
        
    }
    
    public void unfix(int idx) {
        if (flip){
            if (ans[idx] == 0){
                ans[idx] = 1;
                count++;
            }
        }
        else {
            if (ans[idx] == 1){
                ans[idx] = 0;
                count--;
            }
        }
        
    }
    
    public void flip() {
        flip = !flip;
    }
    
    public boolean all() {
        if (count() == len) return true;
        else return false;
    }
    
    public boolean one() {
        if (count() > 0) return true;
        else return false;
    }
    
    public int count() {
        return flip ? len - count : count;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i : ans) {
            sb.append(flip ? 1 - i : i);
        }
        return sb.toString();
    }
}

package pass.weekly_contest.wc2022_02_05;


public class lc6002 {
    int[] ans;
    int len;
    int count = 0;
    public lc6002(int size) {
        ans = new int[size];
        len = size;
    }
    
    public void fix(int idx) {
        if (ans[idx] == 1) return;
        else {
            ans[idx] = 1;
            count++;
        }
    }
    
    public void unfix(int idx) {
        if (ans[idx] == 0) return;
        else {
            ans[idx] = 0;
            count--;
        }
    }
    
    public void flip() {
        for (int i = 0; i < len; i++){
            ans[i] = 1 - ans[i];
        }
        count = len - count;
    }
    
    public boolean all() {
        if (count == len) return true;
        else return false;
    }
    
    public boolean one() {
        if (count > 0) return true;
        else return false;
    }
    
    public int count() {
        return count;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }
        return sb.toString();
    }
}

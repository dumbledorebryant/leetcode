package pass;

public class lc796 {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        return (m == n) && (s + s).contains(goal);
    }
}

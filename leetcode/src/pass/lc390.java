package pass;

public class lc390 {
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        int prevRemaining = lastRemaining(n / 2);
        return (n / 2 + 1 - prevRemaining) * 2;
    }
}

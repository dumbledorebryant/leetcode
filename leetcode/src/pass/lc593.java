package pass;

public class lc593 {
    long len = -1;
    public boolean validSquare(int[] a, int[] b, int[] c, int[] d) {
        return calc(a, b, c) && calc(a, b, d) && calc(a, c, d) && calc(b, c, d);
    }
    boolean calc(int[] a, int[] b, int[] c) {
        long l1 = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
        long l2 = (a[0] - c[0]) * (a[0] - c[0]) + (a[1] - c[1]) * (a[1] - c[1]);
        long l3 = (b[0] - c[0]) * (b[0] - c[0]) + (b[1] - c[1]) * (b[1] - c[1]);
        boolean ok = (l1 == l2 && l1 + l2 == l3) || (l1 == l3 && l1 + l3 == l2) || (l2 == l3 && l2 + l3 == l1);
        if (!ok) return false;
        if (len == -1) len = Math.min(l1, l2);
        else if (len == 0 || len != Math.min(l1, l2)) return false;
        return true;
    }
}

package pass;

public class lc278 {
    public int firstBadVersion(int n) {
        return findBadVersion(1, n);
    }
    public int findBadVersion(int i, int j){
        if (i == j) return i;
        if (j - i == 1) return isBadVersion(i) ? i : j;
        int mid = i + ((j - i) >> 1);
        if (isBadVersion(mid)) return findBadVersion(i, mid - 1);
        else return findBadVersion(mid + 1, j);
    }

    public boolean isBadVersion(int i){
        return false;
    }
}

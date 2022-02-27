package pass;

public class lc780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy){
            if (tx > ty){
                if (ty == sy) return (tx - sx) % ty == 0;
                tx %= ty;
            }
            else {
                if (tx == sx) return (ty - sy) % tx == 0;
                ty %= tx;
            }
        }
        
        return false;
    }
}

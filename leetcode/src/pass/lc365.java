package pass;

public class lc365 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        int a = Math.max(jug1Capacity, jug2Capacity);
        int b = Math.min(jug1Capacity, jug2Capacity);

        int c = a + b;
        while (c != 0) {
            if (c == targetCapacity) {
                return true;
            }

            if (c >= b) {
                c -= b;
            } else {
                c += a;
            }
        }
        
        return false;
    }
}

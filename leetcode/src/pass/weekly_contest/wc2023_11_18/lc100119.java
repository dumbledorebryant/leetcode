package pass.weekly_contest.wc2023_11_18;

public class lc100119 {
    public int maximumXorProduct(long a, long b, int n) {
        long ans = 0;
        int flag = 0;
        if (a > b) flag = 1;
        for (int i = n - 1; i >= 0; i--){
            int x = (int)((a >> i) & 1);
            int y = (int)((b >> i) & 1);
            if (x == y && x == 0){
                ans |= (1 << i);
                continue;
            }
            if (x == y && x == 1){
                continue;
            }
            if (flag == 0){
                if (x == 0){
                    ans |= (1 << i);
                    if ((ans ^ a) > (ans ^ b)) flag = 1;
                    continue;
                }
            }
            if (flag == 1){
                if (y == 0){
                    ans |= (1 << i);
                    if ((ans ^ b) > (ans ^ a)) flag = 0;
                    continue;
                }
            }
        }
        return (int)(((a ^ ans) % (1e9 + 7)) * ((b ^ ans) % (1e9 + 7)) % (1e9 + 7));
    }
}

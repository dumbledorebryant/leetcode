package pass;

public class lc1864 {
    public int minSwaps(String s) {
        char[] cs = s.toCharArray();
		int len = cs.length;
		// 假设以1开头，需要交换n11个1，需要交换n10个0
		int s1 = 1, n11 = 0, n10 = 0;
		// 假设以0开头，需要交换n01个1，需要交换n00个0
		int n01 = 0, n00 = 0;
		for (int i = 0; i < len; i++) {
			boolean one = cs[i] == '1';
			if (s1 == 1) {
				n11 += one ? 0 : 1;
				n00 += one ? 1 : 0;
			} else {
				n10 += one ? 1 : 0;
				n01 += one ? 0 : 1;
			}
			s1 ^= 1;// 相邻10互换
		}
		int ans = n11 == n10 ? n11 : -1;
		return n01 == n00 ? ans == -1 ? n01 : Math.min(ans, n01) : ans;
    }
}

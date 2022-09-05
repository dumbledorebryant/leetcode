package pass;

public class lc1864 {
    public int minSwaps(String s) {
        // 类似前缀和
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
            else {
                count--;
            }
        }

        // 如果01差值大于1自然无法构建，那么就是-1
        if (Math.abs(count) > 1) {
            return -1;
        }

        // 01一样多，那么就两种情况取小值
        if (count == 0) {
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0 && s.charAt(i) == '0') {
                    count1++;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1 && s.charAt(i) == '0') {
                    count2++;
                }
            }
            return Math.min(count1, count2);
        }

        // 1多
        if (count == 1) {
            int count1 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0 && s.charAt(i) == '0') {
                    count1++;
                }
            }
            return count1;
        }

        // 0多
        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0 && s.charAt(i) == '1') {
                count1++;
            }
        }
        return count1;
    }
}

package pass.OA.Doordash;

import java.util.*;

public class calculate {
    public static int calculateDifference(String a, String b) {
        int[] lToR = new int[b.length() + 1], rToL = new int[b.length() + 1];
        if (LCS(a, b, Integer.MAX_VALUE, lToR) | LCS(a, b, -1, rToL)) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < b.length(); ++i) {
            if (lToR[i] != Integer.MAX_VALUE) {
                int closest = upperBound(rToL, lToR[i]);
                ans = Math.min(ans, closest - i);
            }
        }
        return ans;
    }

    private static int upperBound(int[] rToL, int idx) {
        int left = 0, right = rToL.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (rToL[mid] <= idx) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == rToL.length || rToL[left] < idx) {
            return Integer.MAX_VALUE;
        }
        return left;
    }

    private static boolean LCS(String a, String b, int defaultVal, int[] idx) {
        Arrays.fill(idx, defaultVal);
        if (defaultVal == Integer.MAX_VALUE) {
            idx[0] = -1;
            int pb = 0;
            for (int pa = 0; pa < a.length(); ++pa) {
                if (pb == b.length()) return true;
                if (a.charAt(pa) == b.charAt(pb)) {
                    idx[pb + 1] = pa;
                    ++pb;
                }
            }
        } else {
            idx[b.length()] = a.length();
            int pb = b.length() - 1;
            for (int pa = a.length() - 1; pa >= 0; --pa) {
                if (pb == -1) return true;
                if (a.charAt(pa) == b.charAt(pb)) {
                    idx[pb] = pa;
                    --pb;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(calculateDifference("abc", "eeabc"));
        System.out.println(calculateDifference("abc", "abcee"));
        System.out.println(calculateDifference("ABACABA", "ABA"));
        System.out.println(calculateDifference("HACKERRANK", "HACKERMANK"));
        System.out.println(calculateDifference("daebfc", "abcdef"));
        System.out.println(calculateDifference("aaa", "aaaaa"));
        System.out.println(calculateDifference("exafxxgbcdh", "abcdefgh"));
    }
}

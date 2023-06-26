package pass.Company.Beaconfire;

import java.util.Arrays;
import java.util.Collections;

public class Week6Day1Mock {
    public static String rotateCharacters(String str, int rotationFactor){
        //your code here...
        StringBuilder sb = new StringBuilder();
        
        for (char ch : str.toCharArray()){
            if (Character.isAlphabetic(ch)){
                if (Character.isLowerCase(ch)){
                    sb.append((char)((ch + rotationFactor + 26 - 'a') % 26 + 'a'));
                }
                if (Character.isUpperCase(ch)){
                    sb.append((char)((ch + rotationFactor + 26 - 'A') % 26 + 'A'));
                }
            }
            else if (Character.isDigit(ch)){
                sb.append((ch - '0' + rotationFactor) % 10);
            }
            else sb.append(ch);
        }
        return sb.toString();
    }

    public static int packageBoxes(int[] items, int k) {
        // your code
        int length = items.length;
        Arrays.sort(items);
        int ans = 0;
        int cw = 0;
        int idx = 0;

        while (idx < length) {
            if (cw + items[idx] <= k) {
                cw += items[idx];
                idx++;
            } else {
                ans++;
                cw = 0;
            }

            if (cw == k || cw + items[idx] > k) {
                ans++;
                cw = 0;
            }
        }

        if (cw > 0) {
            ans++;
        }

        return ans;
    }

    public static int minIndexDiff(int[] arr, int num1, int num2){
        //your code here...
        int a = -1;
        int b = -1;
        int length = arr.length;
        int idx = 0;
        int ans = Integer.MAX_VALUE;
        while (idx < length){
            if (arr[idx] == num1) {
                a = idx;
                if (b != -1){
                    ans = Math.min(ans, Math.abs(a - b));
                }
            }
            else if (arr[idx] == num2){
                b = idx;
                if (a != -1){
                    ans = Math.min(ans, Math.abs(a - b));
                }
            }
            // System.out.println("a, b, |a-b|: " + a + " " + b + " " + Math.abs(a - b));
            
            idx++;
        }

        
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rotateCharacters("A-b!c", 2));
        System.out.println(rotateCharacters("39ZA", 4));

        System.out.println(packageBoxes(new int[]{2, 3}, 5));
        System.out.println(packageBoxes(new int[]{4, 4, 2, 3}, 4));

        System.out.println(minIndexDiff(new int[]{2, 9, 4, 3, 5, 6, 2, 5, 9, 4}, 2, 4));
        System.out.println(minIndexDiff(new int[]{ 2, 9, 4, 3, 6, 4, 4, 2, 5}, 4, 4));
    }
}

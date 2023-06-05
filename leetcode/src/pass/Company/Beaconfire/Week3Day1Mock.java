package pass.Company.Beaconfire;

import java.util.*;

public class Week3Day1Mock {
    public static int[] hillClimbing(int[] heights){
        int n = heights.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            int num = heights[i];
            while (!dq.isEmpty() && heights[dq.getLast()] < num){
                int pre = dq.removeLast();
                ans[pre] = i - pre; 
            }
            dq.addLast(i);
        }
        return ans;
    }

    public static List<Integer> getIndexes(String sentence, String prefix) {
        // start your code here
        sentence = sentence.toLowerCase();
        String[] list = sentence.split(" ");
        int idx = 0;
        List<Integer> ans = new ArrayList<>();
        for (String str : list){
            if (str.startsWith(prefix)){
                ans.add(idx);
            }
            idx += str.length();
            idx++;
        }
        return ans;
    }

    public static int[] findInterval2(int[][] intervals){
        int[] list = new int[106];
        int a = -1;
        int b = -2;
        for (int[] interval : intervals){
            int i = interval[0];
            int j = interval[1];
            list[i] += 1;
            if (j < 106) list[j] -= 1;
        }

        int pre = -1;
        int[] res = new int[106];
        res[0] = list[0];
        for (int i = 1; i < 106; i++){
            res[i] = res[i - 1] + list[i];
        }
        for (int i = 0; i < 16; i++){
            System.out.print(res[i]);
        }
        System.out.println();
        for (int i = 0; i < 106; i++){
            int num = res[i];
            if (num >= pre){
                System.out.println("cur: " + num);
                System.out.println("cur idx: " + i);
                int aa = i;
                int j = i;
                while (j < 106 && res[j] == num){
                    j++;
                }
                int bb = j;
                i = bb - 1;
                
                if (num > pre){
                    b = bb;
                    a = aa;
                }
                if (num == pre && bb - aa > b - a) {
                    b = bb;
                    a = aa;
                }
                pre = num;
            }
        }
        return new int[]{a, b};
    }

    public static int[] findInterval(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        return new int[]{-1, -1};
    }
    
    public static void main(String[] args) {
        // int[] heights = new int[]{78, 90, 65, 51, 87, 99, 100, 31, 150};
        // int[] res = hillClimbing(heights);
        // for (int num : res){
        //     System.out.print(num);
        //     System.out.print(" ");
        // }
        // System.out.println();

        // String s1 = "a aa Aaa abca bca";
        // String p1 = "a";
        // String p2 = "bc";
        // System.out.println(getIndexes(s1, p1));
        // System.out.println(getIndexes(s1, p2));

        int[][] input1 = new int[][]{{1, 4}, {2, 9}, {3, 5}, {8, 10}};
        int[][] input2 = new int[][]{{2, 3}, {5, 9}, {1, 2}, {10, 14}};
        int[] res1 = findInterval(input1);
        System.out.print(res1[0]);
        System.out.print(res1[1]);
        System.out.println();
        int[] res2 = findInterval(input2);
        System.out.print(res2[0]);
        System.out.print(res2[1]);
        System.out.println();
    }
}

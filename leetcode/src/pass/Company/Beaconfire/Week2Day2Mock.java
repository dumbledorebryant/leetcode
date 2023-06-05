package pass.Company.Beaconfire;
import java.util.*;

import pass.ListNode;
public class Week2Day2Mock {
    public List<String> formMinCoolStrings(String s, int k){
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(chrs[0]);
        char min = chrs[0];
        char max = chrs[0];
        for (int i = 1; i < length; i++){
            char ch = chrs[i];
            if (Math.abs(ch - min) <= k && Math.abs(ch - max) <= k){
                sb.append(ch);
                if (ch > max) max = ch;
                if (ch < min) min = ch;
            }
            else {
                ans.add(sb.toString());
                min = ch;
                max = ch;
                sb = new StringBuilder();
                sb.append(ch);
            }
        }
        ans.add(sb.toString());
        return ans;
    }

    public int[] sumOfBorders(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++){
            if (i <= n - 1 - i){
                res.add(sumb(matrix, i, n - 1 - i));
            }
        }
        int size = res.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) ans[i] = res.get(i);
        return ans;
    }

    public int sumb(int[][] matrix, int left, int right){
        if (left == right) return matrix[left][right];
        int sum = 0;
        for (int i = left; i <= right; i++){
            sum += matrix[i][left];
            sum += matrix[i][right];
        }
        for (int i = left + 1; i <= right - 1; i++){
            sum += matrix[left][i];
            sum += matrix[right][i];
        }
        return sum;
    }

    public int sumOfLinkedList(ListNode l1, ListNode l2){
        StringBuilder sb1 = new StringBuilder();
        while (l1 != null){
            sb1.append(l1.val);
            l1 = l1.next;
        }

        int a = Integer.valueOf(sb1.toString());
        System.out.println(sb1.toString());
        StringBuilder sb2 = new StringBuilder();
        while (l2 != null){
            sb2.append(l2.val);
            l2 = l2.next;
        }
        int b = Integer.valueOf(sb2.toString());
        System.out.println(sb2.toString());
        return a + b;
    }

    public void test(){
        String s = "zzzaazza";
        int k = 20;
        System.out.println(formMinCoolStrings(s, k));

        int[][] matrix = new int[][]{{9, 7, 4, 5}, {1, 6, 2, -6}, {12, 20, 2, 0}, {-5, -6, 7, -2}};
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] res = sumOfBorders(matrix1);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);

            
 
        // creating first list
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
     
        // creating second list
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(9);

        System.out.println(sumOfLinkedList(head1, head2));
    }
}

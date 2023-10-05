package pass;
import java.util.*;

import pass.ListNode;
public class lc382 {
    List<Integer> list;
    public lc382(ListNode head) {
        list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        Random r = new Random();
        int length = list.size();
        int pick = r.nextInt(length);
        return list.get(pick);
    }

    int[] getRandom2(ListNode head, int k) {
        Random r = new Random();
        int[] res = new int[k];
        ListNode p = head;
    
        // 前 k 个元素先默认选上
        for (int i = 0; i < k && p != null; i++) {
            res[i] = p.val;
            p = p.next;
        }
    
        int i = k;
        // while 循环遍历链表
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            int j = r.nextInt(i);
            // 这个整数小于 k 的概率就是 k/i
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;
    }
}

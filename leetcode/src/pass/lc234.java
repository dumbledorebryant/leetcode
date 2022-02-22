package pass;

import java.util.ArrayList;
import java.util.List;

public class lc234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        int a = 0; 
        int b = len - 1;
        while (a < b){
            if (list.get(a) != list.get(b)){
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
}

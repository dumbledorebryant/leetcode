package pass;
import java.util.*;

public class lc316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();
        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;

            if (inStack[c]) continue;

            while (!stk.isEmpty() && stk.peek() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stk.peek()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }

    public String redo(String s){
        Deque<Character> stack = new LinkedList<>();
        char[] chrs = s.toCharArray();
        int[] count = new int[26];
        boolean[] inStack = new boolean[256];
        for (char ch : chrs){
            count[ch - 'a']++;
        }
        for (char ch : chrs){
            if (inStack[ch]) continue;
            inStack[ch] = true;
            while (!stack.isEmpty() && stack.getLast() >= ch){
                if (count[stack.getLast() - 'a'] > 0){
                    inStack[stack.removeLast()] = false;
                }
            }
            stack.addLast(ch);
            count[ch - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        System.out.println("hell0");
        while (!stack.isEmpty()){
            char ch = stack.removeFirst();
            System.out.println(ch);
            System.out.println(stack.size());
            sb.append(ch);
        }
        return sb.toString();
    }
}

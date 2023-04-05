package pass;

import java.util.*;

public class lc402 {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        char[] chrs = num.toCharArray();
        int count = 0;
        int length = chrs.length;
        if (k == length) return "0";
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++){
            char ch = chrs[i];
            while (!stack.isEmpty() && stack.getLast() > ch){
                count++;
                stack.removeLast();
                if (count == k) {
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty()){
                        sb.append(stack.getFirst());
                    }
                    sb.append(num.substring(i, length));
                    int j = 0;
                    int size = sb.length();
                    while (j < size && sb.charAt(j) == '0'){
                        j++;
                    }
                    sb.delete(0, j);
                    return sb.length() == 0 ? "0" : sb.toString();
                }
            }
            stack.add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.getFirst());
        }
        int size = sb.length();
        sb.delete(size - (k - count), size);
        int j = 0;
        size = sb.length();
        while (j < size && sb.charAt(j) == '0'){
            j++;
        }
        sb.delete(0, j);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

package pass;

import java.util.*;

public class lc6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }
        int length = s.length();
        int j = 0;
        int flag = 1;
        for (int i = 0; i < length; i++){
            list.get(j).append(s.charAt(i));
            j += flag;
            if (j == 0 || j == numRows - 1){
                flag = - flag;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public String zigzag(String s, int numRows){
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }
        int j = 0;
        int flag = -1;
        int length = s.length();
        for (int i = 0; i < length; i++){
            char ch = s.charAt(i);
            list.get(j).append(ch);
            if (j == 0 || j == numRows - 1){
                flag = - flag;
            }
            j += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder sbd : list){
            sb.append(sbd);
        }
        return sb.toString();
    }
}

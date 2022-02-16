package pass;

import java.util.*;

public class lc151 {
    public String reverseWords(String s) {
        String[] list = s.split(" ");
        int length = list.length;
        List<String> nlist = new ArrayList<>();
        for (int i = 0; i < length; i++){
            String str = list[i];
            if (str.length() != 0)
                nlist.add(str);
        }
        System.out.println(nlist.size());
        int size = nlist.size();
        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 1; i--){
            sb.append(nlist.get(i)).append(" ");
        }
        sb.append(nlist.get(0));
        return sb.toString();
    }
}

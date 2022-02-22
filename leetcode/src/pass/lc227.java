package pass;
import java.util.*;

import javax.print.DocFlavor.STRING;
public class lc227 {
    public int calculate(String s) {
        List<String> list = new ArrayList<>();
        s = s.replace(" ", "");
        s = s.replace("+", " + ");
        s = s.replace("-", " - ");
        s = s.replace("*", " * ");
        s = s.replace("/", " / ");
        String[] tmp = s.split(" ");
        int length = tmp.length;
        for (int i = 0; i < length; i++){
            String str = tmp[i];
            switch (str){
                case "*":
                {
                    int pre = Integer.parseInt(list.remove(list.size() - 1));
                    i++;
                    int next = Integer.parseInt(tmp[i]);
                    String sub = String.valueOf(pre * next);
                    list.add(sub); 
                    break;
                }
                case "/":
                {
                    int pre = Integer.parseInt(list.remove(list.size() - 1));
                    i++;
                    int next = Integer.parseInt(tmp[i]);
                    String sub = String.valueOf(pre / next);
                    list.add(sub); 
                    break;
                }
                default:
                {
                    list.add(str);
                    break;
                }
            }
        }
        System.out.println(list);
        //int ans = Integer.parseInt(stack.pop());
        int ans = Integer.parseInt(list.get(0));
        for (int i = 1; i < list.size(); i++){
            String str = list.get(i);
            if (str.equals("+")){
                i++;
                int next = Integer.parseInt(list.get(i));
                System.out.println(next);
                ans += next;
            }
            else if (str.equals("-")){
                i++;
                int next = Integer.parseInt(list.get(i));
                ans -= next;
            }
        }
        return ans;
    }
}

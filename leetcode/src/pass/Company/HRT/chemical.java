package pass.Company.HRT;
import java.util.*;
public class chemical {
    boolean solution(String s) {
        String[] arr = s.split(" = ");
        String[] left = arr[0].split(" \\+ ");
        String[] right = arr[1].split(" \\+ ");
    
        Map<String, Integer> rightMap = new HashMap<>();
        Map<String, Integer> leftMap = new HashMap<>();
    
        for(String item: left){
            addAtom(item, leftMap);
        }
        for(String item: right){
            addAtom(item, rightMap);
        }
    
        Set<String> leftKey = leftMap.keySet();
        Set<String> rightKey = rightMap.keySet();

        for(String atom: leftKey){
            if(!rightKey.contains(atom)){
                return false;
            }
            if(leftMap.get(atom) != rightMap.get(atom)){
                return false;
            }
        }
    
        return true;
    }

    public void addAtom(String s, Map<String, Integer> mymap){
        int startNum = 0;
        int l = s.length();
        int i = 0;
    
        while(i < l && Character.isDigit(s.charAt(i))){                 // leftmost number
            startNum *= 10;
            startNum += s.charAt(i) - '0';
            i++;
        }
        if(startNum == 0){
            startNum = 1;
        }
        while(i < l){
            char c = s.charAt(i);
            StringBuilder sb = new StringBuilder();
            if(Character.isUpperCase(c)){                               // start an atom
                sb.append(s.charAt(i));
                i++;
                while(i < l && Character.isLowerCase(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                }
            
                int num = 0;
                while(i < l && Character.isDigit(s.charAt(i))){             // suffix number
                    num *= 10;
                    num += s.charAt(i) - '0';
                    i++;
                }
                if(num == 0){
                    num = 1;
                }
                String atom = sb.toString();
                mymap.put(atom, mymap.getOrDefault(atom, 0) + num * startNum);
            }
            else{
                i++;
            }
        }
    }
}

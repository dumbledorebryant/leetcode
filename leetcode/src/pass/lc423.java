package pass;

import java.util.HashMap;
import java.util.Map;

public class lc423 {
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Map<Integer, Integer> res = new HashMap<>();

        if (map.containsKey('g')){
            int num = map.get('g');
            res.put(8, num);
            String str = "eiht";
            for (char ch : str.toCharArray()){
                map.put(ch, map.get(ch) - num);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }

        if (map.containsKey('h')){
            int num = map.get('h');
            res.put(3, num);
            String str = "tree";
            for (char ch : str.toCharArray()){
                map.put(ch, map.get(ch) - num);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }

        if (map.containsKey('w')){
            int num = map.get('w');
            res.put(2, num);
            String str = "to";
            for (char ch : str.toCharArray()){
                map.put(ch, map.get(ch) - num);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }

        if (map.containsKey('z')){
            int num = map.get('z');
            res.put(0, num);
            String str = "ero";
            for (char ch : str.toCharArray()){
                map.put(ch, map.get(ch) - num);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }

        if (map.containsKey('x')){
            int num = map.get('x');
            res.put(6, num);
            String str = "si";
            for (char ch : str.toCharArray()){
                map.put(ch, map.get(ch) - num);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }
        if (map.containsKey('s')){
            int num = map.get('s');
            res.put(7, num);
            String str = "even";
            for (char ch : str.toCharArray()){
                map.put(ch, map.get(ch) - num);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }
        if (map.containsKey('v')){
            int num = map.get('v');
            res.put(5, num);
            String str = "fie";
            for (char ch : str.toCharArray()){
                map.put(ch, map.get(ch) - num);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }
        if (map.containsKey('f')){
            int num = map.get('f');
            res.put(4, num);
            String str = "our";
            for (char ch : str.toCharArray()){
                map.put(ch, map.get(ch) - num);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }

        if (map.containsKey('o')){
            int num = map.get('o');
            res.put(1, num);
            String str = "ne";
            for (char ch : str.toCharArray()){
                map.put(ch, map.get(ch) - num);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }

        if (map.containsKey('i')){
            int num = map.get('i');
            res.put(9, num);
            String str = "nne";
            for (char ch : str.toCharArray()){
                map.put(ch, map.get(ch) - num);
                if (map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++){
            if (res.containsKey(i)){
                for (int j = 0; j < res.get(i); j++){
                    sb.append(i);
                }
            }
        }
        return sb.toString();
    }
}

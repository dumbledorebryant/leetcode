package pass.Company.Expedia;
import java.util.*;
public class Cpairs{
    public long count(List<String> list){
        long ans = 0;
        Map<Integer, Long> map = new HashMap<>();
        int size = list.size();
        for (int i = 0; i < size; i++){
            String str = list.get(i);
            int cur = 0;
            for (int j = 0; j < str.length(); j++){
                cur ^= (1 << (str.charAt(j) - 'a'));
            }
            ans += map.getOrDefault(cur, 0L);
            for (int k = 0; k < 26; k++){
                int tmp = cur ^ (1 << k);
                ans += map.getOrDefault(tmp, 0L);
            }
            map.put(cur, map.getOrDefault(cur, 0L) + 1);           
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abcd");
        list.add("bc");
        list.add("adc");
        Cpairs cp = new Cpairs();
        System.out.println(cp.count(list));
    }
}
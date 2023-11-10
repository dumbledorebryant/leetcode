package pass.Company.Tiktok.11.06;
import java.util.*;
public class message {
    public List<String> getStatus(List<String> messages, List<Integer> timelist, int k){
        Map<String, Integer> map = new HashMap<>();
        int n = messages.size();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String str = messages.get(i);
            int time = timelist.get(i);
            if (!map.containsKey(str)){
                ans.add("true");
            }
            else {
                int pre = map.get(str);
                if (time - pre <= k){
                    ans.add("false");
                }
                else {
                    ans.add("true");
                }
            }
            map.put(str, time);
        }
        return ans;
    }
}

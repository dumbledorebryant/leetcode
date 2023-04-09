package pass;
import java.util.*;;
public class lc254 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        if (n <= 3) return ans;
        get(n, -1, new ArrayList<>());
        return ans;
    }

    public void get(int n, int low, List<Integer> list){
        if (low != -1) {
            list.add(n);
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
        
        for (int i = Math.max(2, low); i * i <= n; i++){
            if (n % i == 0){
                list.add(i);
                get(n / i, i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}

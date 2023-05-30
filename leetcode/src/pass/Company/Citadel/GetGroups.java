package pass.Company.Citadel;
import java.util.*;;
public class GetGroups {
    class UF {
        // 连通分量个数
        private int count;
        // 存储每个节点的父节点
        private int[] parent;

        public int[] nums;
    
        // n 为图中节点的个数
        public UF(int n) {
            this.count = n;
            parent = new int[n];
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                nums[i] = 1;
            }
        }

        public int getCount(int node){
            int root = find(node);
            return nums[root];
        }
        
        // 将节点 p 和节点 q 连通
        public void union(int p, int q) {
            int sa = nums[find(p)];
            int sb = nums[find(q)];
            int rootP = find(p);
            int rootQ = find(q);
            
            if (rootP == rootQ)
                return;
            
            parent[rootQ] = rootP;
            // 两个连通分量合并成一个连通分量
            count--;
            nums[rootP] = sa + sb;
        }
    
        // 判断节点 p 和节点 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    
        // 返回图中的连通分量个数
        public int count() {
            return count;
        }
    }
    public int getTheGroups(int n, List<String> qtype, int[] s1, int[] s2){
        int length = qtype.size();
        UF uf = new UF(n);
        int ans = 0;
        for (int i = 0; i < length; i++){
            String type = qtype.get(i);
            int sa = s1[i] - 1;
            int sb = s2[i] - 1;
            if (type.equals("Friend")){
                uf.union(sa, sb);
            }
            else {
                ans = uf.getCount(sa) + uf.getCount(sb);
                break;
            }
        }
        return ans;
    }   

    public static void main(String[] args) {
        List<String> qtype = new ArrayList<>();
        qtype.add("Friend");
        qtype.add("Friend");
        qtype.add("Total");
        int[] s1 = {1, 2, 1};
        int[] s2 = {2, 3, 4};
        int[] s3 = {1};
        int[] s4 = {2};
        int n = 4;
        int n2 = 2;
        GetGroups gg = new GetGroups();
        System.out.println(gg.getTheGroups(n, qtype, s1, s2));
    }

    
}

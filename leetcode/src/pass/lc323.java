package pass;
import pass.UF;
public class lc323 {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.count();
    }
}

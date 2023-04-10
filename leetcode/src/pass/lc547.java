package pass;

import java.util.*;

public class lc547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (isConnected[i][j] == 1){
                    if (!uf.connected(i, j)){
                        uf.union(i, j);
                    }
                }
            }
        }
        return uf.count();
    }
}

package pass;

import java.util.List;

public class lc339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    public int dfs(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for (NestedInteger ni : nestedList){
            if (ni.isInteger()) sum += depth * ni.getInteger();
            else {
                
                sum += dfs(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
}

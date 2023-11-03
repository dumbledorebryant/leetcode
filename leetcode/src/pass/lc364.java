package pass;

import java.util.ArrayList;
import java.util.List;

public class lc364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }
    
    private int helper(List<NestedInteger> niList, int prev) {
        int intSum = prev;
        List<NestedInteger> levelBreak = new ArrayList<>();
        
        for (NestedInteger ni : niList) {
            if (ni.isInteger()) {
                intSum += ni.getInteger();
            } else {
                levelBreak.addAll(ni.getList());
            }
        }
        
        int listSum = levelBreak.isEmpty()? 0 : helper(levelBreak, intSum);

        return listSum + intSum;
    }
}

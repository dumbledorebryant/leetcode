package pass;
import java.util.*;

public class lc341 implements Iterator<Integer>{
    List<Integer> list = new ArrayList<>();
    int index = 0;
    public lc341(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    void dfs(List<NestedInteger> nestedList){
        for (NestedInteger item : nestedList){
            if (item.isInteger()){
                list.add(item.getInteger());
            }
            else {
                dfs(item.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        if (index == list.size()) return false;
        else return true;
    }
}

package pass.OA.Amazon;

import java.util.HashMap;

public class findMiddleCapacity {
    public int shipParcelFactors(int[] array){
        if (array == null){
            return -1;
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        int[] globalMax = new int[] {-1};
        int length = array.length;
        for (int start = 0; start < length; start++){
            if (!map.containsKey(array[start])){
                checkFactor(map, array, start, globalMax);
            }
        }
        return globalMax[0];
    }

    public void checkFactor(HashMap<Integer, Boolean> map, int[] array, int start, int[] globalMax){
        boolean inputValue = false;
        int num = array[start];
        for (int i = 0; i * i <= num; i++){
            Boolean o1 = map.get(num / i);
            Boolean o2 = map.get(i);
            if (o1 != null){
                inputValue = true;
                if (o1){
                    globalMax[0] = Math.max(globalMax[0], num / i);
                }
            }
            if (o2 != null){
                inputValue = true;
                if (o2){
                    globalMax[0] = Math.max(globalMax[0], i);
                }
            }
        }
        map.put(num, inputValue);
    }
}

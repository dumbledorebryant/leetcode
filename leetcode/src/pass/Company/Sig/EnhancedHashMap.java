package pass.Company.Sig;
import java.util.*;

public class EnhancedHashMap {
    public long enhancedMap(String[] queryType, int[][] query) {
        // corner case
        if (queryType.length == 0 || query.length == 0) {
            return 0;
        }

        long result = 0;
        long keyAdded = 0;
        long valueAdded = 0;
        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < queryType.length; i++) {
            String currQuery = queryType[i];
            int[] queryContent = query[i];

            if (currQuery.equals("insert")) {
                map.put(queryContent[0] - keyAdded, queryContent[1] - valueAdded);
            }
            else if (currQuery.equals("get")) {
                result += map.get(queryContent[0] - keyAdded) + valueAdded;
            }
            else if (currQuery.equals("addToKey")) {
                keyAdded += queryContent[0];
            }
            else if (currQuery.equals("addToValue")) {
                valueAdded += queryContent[0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EnhancedHashMap test = new EnhancedHashMap();
        String[] queryType = new String[] {"insert", "insert", "addToValue", "addToKey", "get"};

        int[] q1 = new int[] {1, 2};
        int[] q2 = new int[] {2, 3};
        int[] q3 = new int[] {2};
        int[] q4 = new int[] {1};
        int[] q5 = new int[] {3};
        int[][] query = new int[][] {q1, q2, q3, q4, q5};

        System.out.println(test.enhancedMap(queryType, query)); // 5
    }
}

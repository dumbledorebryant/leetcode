import java.util.Arrays;

public class SpringTraining {
    public static void main(String[] args){
        int[] sprints = new int[]{2, 4, 1, 3};
        int n = sprints.length;
        int[] result = new int[n + 2];

        int i = 0;
        int j = 1;
        while(j < n){
            int start = Math.min(sprints[i],sprints[j]);
            int end = Math.max(sprints[i],sprints[j]);
            
            result[start]++;
            result[end + 1]--;
            i++;
            j++;
        }

        int max = -1;
        int idx = -1;
        for(int k = 1; k <= n; k++){
            result[k] += result[k - 1];
            if(result[k] > max){
                max = result[k];
                idx = k;
            }
        }
        System.out.println(Arrays.toString(result));
        System.out.println(idx);

    }
}

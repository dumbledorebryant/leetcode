package pass;

public class lc1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int length = arr.length;
        int sum = 0;
        for (int win = 1; win <= length; win += 2){
            for (int i = 0; i + win <= length; i++){
                for (int j = 0; j < win; j++){
                    sum += arr[i + j];
                }
            }
        }
        return sum;
    }

    public int presumSolution(int[] arr) {
        int length = arr.length;
        int[] sum = new int[length + 1];
        for (int i = 1; i <= length; i++){
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        int ans = 0;

        for (int i = 0; i < length; i++){
            for (int win = 1; i + win <= length; win += 2){
                ans += sum[i + win] - sum[i];
            }
        }
        return ans;
    }
}

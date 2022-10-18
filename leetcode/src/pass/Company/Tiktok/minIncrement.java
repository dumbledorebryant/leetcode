package pass.Company.Tiktok;

public class minIncrement {
    public int minInc(int[] arr){
        if (arr == null) return 0;
        int length = arr.length;
        if (length == 0) return 0;
        int max = 0;
        for (int x : arr){
            max = Math.max(max, x);
        }

        int[] freq = new int[length + max];
        for (int num : arr){
            freq[num]++;
        }
        
        for (int i = 0; i < freq.length - 1; i++){
            if (freq[i] <= 1){
                continue;
            }
            int remain = freq[i] - 1;
            freq[i + 1] += remain;
        }
        int sum = 0;
        for (int i : freq){
            sum += i;
        }
        return sum;
    }
}

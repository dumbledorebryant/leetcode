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
        
        for (int i = 0; i < freq.length; i++){
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
    public int minIncrementForUnique(int[] nums) {
        if (nums.length == 0) {
			return 0;
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}
		int[] countmap = new int[max + nums.length - min];
		for (int num : nums) {
			countmap[num - min]++;
		}
		int opnum = 0;
		for (int num = 0; num < countmap.length; num++) {
			int del = countmap[num] - 1;
			if (del > 0) {
				countmap[num + 1] += del;
				opnum += del;
			}
		}
        int sum = opnum;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        System.out.println(sum);
		return opnum;
    }
}

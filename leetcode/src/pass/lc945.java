package pass;

public class lc945 {
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
		for (int num = min; num < countmap.length; num++) {
			int del = countmap[num - min] - 1;
			if (del > 0) {
				countmap[num + 1 - min] += del;
				opnum += del;
			}
		}
		return opnum;
    }
}

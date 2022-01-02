package pass.jzoffer;

public class jzoffer69undone {
    public int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;
        int i = 0;
        for (; i < length - 1; i++){
            int curr = arr[i];
            int next = arr[i + 1];
            if (curr > next) break;
        }
        return 0;
    }
}

package pass;

public class lc88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) nums1[i] = nums2[i];
            return;
        }
        if (n == 0) return;

        int left = m - 1;
        int right = n - 1;
        int index = m + n - 1;
       
        while (left >= 0 && right >= 0){
            int l = nums1[left];
            int r = nums2[right];
            if (l >= r) {
                left--;
                nums1[index] = l;
            }
            else {
                right--;
                nums1[index] = r;
            }
        }
        while(right >= 0) nums1[right] = nums2[right--];
    }
}

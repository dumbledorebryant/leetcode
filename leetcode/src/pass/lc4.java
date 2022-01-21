package pass;

public class lc4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return 0;
        }
        
        if(nums1 == null){
            int n = nums2.length;
            return nums2[(n - 1) / 2] * 0.5 + nums2[n / 2] * 0.5;
        }
        
        if(nums2 == null){
            int n = nums1.length;
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }
        
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int l = 0;
        int r = m;
        while (l < r){
            int i = (l + r)/2;
            int j = (m + n)/2 - i;
            if (nums1[i] < nums2[j - 1]){
                l = i + 1;
            }
            else r = i;
        }
        int first = l;
        int second = (m + n)/2 - l;

        int shorterleft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterright = first == m ? Integer.MAX_VALUE : nums1[first];

        int longerleft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerright = second == n ? Integer.MAX_VALUE : nums2[second];

        if ((n + m) % 2 == 0){
            return Math.max(shorterleft, longerleft) * 0.5 + Math.min(shorterright, longerright) * 0.5;
        }
        else return Math.min(shorterright, longerright);
    }
}

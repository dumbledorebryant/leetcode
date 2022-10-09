package pass;

public class lc4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;  
    }
    
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1 
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public double findMedian(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { 
            return findMedian(B,A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j-1] > A[i]){ // i 需要增大
                iMin = i + 1; 
            }
            else if (i != 0 && j != n && A[i-1] > B[j]) { // i 需要减小
                iMax = i - 1; 
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }

    public double findMedianArray(int[] nums1, int[] nums2){
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int l = 0;
        int r = m;
        int median1 = 0, median2 = 0;
        while (l <= r){
            int i = l + (r - l)/2;
            int j = (m + n + 1)/2 - i;
            int al = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int ar = i == m ? Integer.MAX_VALUE : nums1[i];
            int bl = i == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int br = j == n ? Integer.MAX_VALUE : nums2[j];

            if (al <= br){
                median1 = Math.max(al, bl);
                median2 = Math.min(ar, br);
                l = i + 1;
            }
            else {
                r = i - 1;
            }
        }
        return (m + n) % 2 == 1 ? median1 * 1.0 : (median1 + median2)/2.0;
    }

    public int getKthEle(int[] nums1, int[] nums2, int k){
        int m = nums1.length;
        int n = nums2.length;
        int ia = 0;
        int ib = 0;
        while (true){
            if (ia >= m) return nums2[ib + k - 1];
            if (ib >= n) return nums1[ia + k - 1];
            if (k == 1) return Math.min(nums1[ia], nums2[ib]);
            int nia = Math.min(ia + k/2, m) - 1;
            int nib = Math.min(ib + k/2, n) - 1;
            int a = nums1[nia];
            int b = nums2[nib];
            if (a <= b){
                k -= (nia - ia + 1);
                ia = nia + 1;
            }
            else {
                k -= (nib - ib + 1);
                ib = nib + 1;
            }
        }
    }
}

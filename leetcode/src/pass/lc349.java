package pass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < m && j < n){
            int a = nums1[i];
            int b = nums2[j];
            if (a == b){
                list.add(a);
                while (i < m && nums1[i] == a) i++;
                while (j < n && nums2[j] == b) j++;
            }
            else if (a < b){
                i++;
            }
            else{
                j++;
            }
        }
        int size = list.size();
        int[] ans = new int[size];
        for (int k = 0; k < size; k++){
            ans[k] = list.get(k);
        }
        return ans;
    }
}

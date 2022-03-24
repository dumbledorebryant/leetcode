package pass;

public class lc315 {
    private class Pair{
        int val, id;
        Pair(int val, int id){
            this.val = val;
            this.id = id;
        }
    }
    Pair[] temp;
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        temp = new Pair[length];
        count = new int[length];
        
        Pair[] arr = new Pair[length];
        
        for (int i = 0; i < length; i++){
            arr[i] = new Pair(nums[i], i);
        }
        
        mergeSort(arr, 0, length - 1);
        List<Integer> ans = new ArrayList<>();
        for (int item : count) ans.add(item);
        return ans;
    }
    public void mergeSort(Pair[] arr, int lo, int hi){
        if (lo == hi) return;
        int mid = lo + ((hi - lo) >> 1);
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }
    public void merge(Pair[] arr, int lo, int mid, int hi){
        for (int i = lo; i <= hi; i++){
            temp[i] = arr[i];
        }
        int a = lo;
        int b = mid + 1;
        for (int ptr = lo; ptr <= hi; ptr++){
            if (a == mid + 1){
                arr[ptr] = temp[b];
                b++;
            }
            else if (b == hi + 1){
                arr[ptr] = temp[a];
                count[arr[ptr].id] += (b - mid - 1);
                a++;
            }
            else if (temp[a].val > temp[b].val){
                arr[ptr] = temp[b];
                
                b++;
            }
            else {
                arr[ptr] = temp[a];
                count[arr[ptr].id] += (b - mid - 1);
                a++;
            }
        }
    }
}

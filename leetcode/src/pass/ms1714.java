package pass;

public class ms1714 {
    public int[] smallestK(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) return ans;

        int length = arr.length;
        quicksort(arr, 0, length - 1, k);
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public void quicksort(int[] arr, int l, int r, int k) {
        if (l >= r) return;
        int pivot = arr[l];

        int i = l;
        int j = r;
        while (i < j){
            
            while (i < j && arr[j] >= pivot) j--;
            while (i < j && arr[i] <= pivot) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);

        if (i < k) quicksort(arr, i + 1, r, k);
        if (i > k) quicksort(arr, l, i - 1, k);
        return;
    }
    
    public void swap(int[] arr, int i, int j){
        int num = arr[i];
        arr[i] = arr[j];
        arr[j] = num;
        return;
    }
}

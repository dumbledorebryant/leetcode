package pass;

public class BinaryS {
    public static int[] solution(int[] arr, int target){
        // using binary search to find the first position
        // find first position
        if(arr.length == 0) return new int[]{-1,-1};
        int l = 0, r = arr.length - 1;
        while(l < r){
            int mid = (l + r) / 2;
            if(arr[mid] < target){
                l = mid + 1; // 右边才可能出现target，所以往右边走
            }else{
                r = mid;
            }
        }
        int first = l;
        // find last position
        l = 0;
        r = arr.length - 1;
        while(l < r){
            // 向上取整
            // 为了防止死循环
            // example: r = l + 1 -> mid = l -> l = mid -> l = r
            // 比如(0,1) 二分mid如果写成(l + r)/2, mid会一次在0，会死循环
            int mid = (l + r + 1) / 2; 
            if(arr[mid] > target){
                r = mid - 1;
            }else{
                l = mid;
            }
        }
        int last = l;
        // check if the target is in the array
        if (arr[first] != target) return new int[]{-1,-1};
        // print the result (如果不存在target, 返回-1，-1)
        return new int[]{first, last};
    }
}

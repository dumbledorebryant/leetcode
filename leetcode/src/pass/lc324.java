package pass;

public class lc324 {
    int[] array;
    public void wiggleSort(int[] nums) {
        int length = nums.length;
        if (length == 1) return;
        array = new int[length];
        int mid = ((length - 1) >> 1);
        int start = 0;
        int end = length - 1;
        
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int a = start;
        int b = mid + 1;
        int begin = start;
        int flag = 0;
        while (a <= mid && b <= end){
            int left = nums[a];
            int right = nums[b];
            if (flag == 0){
                if (left <= right) {
                    array[begin] = left;
                    a++;
                }
                else {
                    array[begin] = right;
                    b++;
                }
                flag = 1;
            }
            else {
                if (left <= right) {
                    array[begin] = right;
                    b++;
                }
                else {
                    array[begin] = left;
                    a++;
                }
                flag = 0;
            }
            
            begin++;
        }
        while(a <= mid){
            if (flag == 0){
                array[begin++] = nums[a++];
                flag = 1;
            }
            else {
                if (a + 1 <= mid){
                    array[begin++] = nums[a + 1];
                    array[begin++] = nums[a++];
                }
                else array[begin++] = nums[a++];
                flag = 0;
            }
        }
        
        //如果右数组没有遍历结束
        while(b <= end){
            if (flag == 0){
                array[begin++] = nums[b++];
                flag = 1;
            }
            else {
                if (b + 1 <= end){
                    array[begin++] = nums[b + 1];
                    array[begin++] = nums[b++];
                }
                else array[begin++] = nums[b++];
                flag = 0;
            }
        }
        for (int i = 0; i < length; i++){
            nums[i] = array[i];
        }
    }
    public static void mergeSort(int [] arr, int left, int right){
        //当子序列中只有一个元素时，也就是left = right时，结束递归
        if(left < right){
            //将当前数组分为两个子数组的分界线
            int mid = (left + right) / 2;

            //对左侧子数组进行递归归并排序
            mergeSort(arr, left, mid);

            //对右侧子数组进行递归归并排序
            mergeSort(arr, mid + 1, right);

            //归并左右侧子序列
            merge(arr, left, mid, right);
        }
    }

    /**
     * 归并排序算法的归并操作，将两个有序数组归并为一个排序数组
     * @param arr 归并前的数组，包含左右两个有序数组
     * @param left 左边界
     * @param mid 两个有序数组的分隔下标
     * @param right 右边界
     */
    public static void merge(int[] arr, int left, int mid, int right){
        //左边数组检测的下标
        int leftIndex = left;
        
        //右边数组检测的下标
        int rightIndex = mid + 1;
        
        //归并后的数组的下标
        int mergeIndex = left;

        //归并排序装归并结果的数组
        int [] mergeArray = new int[arr.length];

        //当左数组和右数组都未到最右边
        while(leftIndex <= mid && rightIndex <= right){
            
            //如果左数组的元素小于等于右数组的元素
            if(arr[leftIndex] <= arr[rightIndex]) {
                
                //将左数组的元素放入归并后的数组，左数组index + 1
                mergeArray[mergeIndex++] = arr[leftIndex++];
                
            //如果左数组元素大于右数组元素
            } else {
                
                //将右数组的元素放入归并后的数组，右数组index + 1
                mergeArray[mergeIndex++] = arr[rightIndex++];
            }
        }//本while循环结束，左右数组至少有一个遍历结束

        //如果左数组没有遍历结束
        while(leftIndex <= mid){
            //将左数组剩下的元素依次放入归并后的数组
            mergeArray[mergeIndex++] = arr[leftIndex++];
        }
        
        //如果右数组没有遍历结束
        while(rightIndex <= right){
            //将右数组剩下的元素依次放入归并后的数组
            mergeArray[mergeIndex++] = arr[rightIndex++];
        }

        //将归并后的有序数组，复制代替原来的数组
        for (int i = left; i <= right; i++){
            arr[i] = mergeArray[i];
        }
    }

    public void test(){
        int[] input = {1,5,1,1,6,4};
        wiggleSort(input);
    }
}

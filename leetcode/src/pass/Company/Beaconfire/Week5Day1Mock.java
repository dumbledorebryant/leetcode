package pass.Company.Beaconfire;

public class Week5Day1Mock {
    public static String shiftCharacters(String s, int k){
        // start your code here...
        int length = s.length();
        k = k % length;
        String str = s + s + s;
        return str.substring(length - k, length - k + length);
    }

    public static int removeIndex(int[] arr){
        // your code...
        int length = arr.length;
        if (length == 1) return 1;
        int idx = -1;
        int count = 0;
        for (int i = 1; i < length; i++){
            if (arr[i - 1] >= arr[i]) {
                count++;
                idx = i;
            }
        }
        if (count > 1) return -1;
        if (count == 0) return length;
        if (idx == 1) return 0;
        if (idx == length - 1) return length - 1;
        if (arr[idx - 1] < arr[idx + 1]) return idx;
        if (idx - 2 >= 0 && arr[idx - 2] < arr[idx]) return idx - 1;
        if (idx < 0) return length;
        return -1;
    }

    public static void main(String[] args) {
        // System.out.println(shiftCharacters("abc", 1));
        // System.out.println(shiftCharacters("abc", -1));
        // System.out.println(shiftCharacters("abc", 4));
        // System.out.println(shiftCharacters("abc", -4));

        int[] input1 = new int[]{1, 999, 998, 997};
        int[] input2 = new int[]{2, 3, 6, 4, 5, 9};
        int[] input3 = new int[]{2, 2, 2};
        int[] input4 = new int[]{2, 2};
        System.out.println(removeIndex(input1));
        System.out.println(removeIndex(input2));
        System.out.println(removeIndex(input3));
        System.out.println(removeIndex(input4));
    }
}

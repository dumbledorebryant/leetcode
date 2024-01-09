package pass;

public class lc978 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        if (n == 2){
            if (arr[0] != arr[1]) return 2;
            else return 1;
        }
        int l = 0;
        int r = 1;
        int cur = 0;
        int res = 1;
        while (r < n){
            int num = arr[r];
            int pre = arr[r - 1];

            System.out.println((num - pre) * cur);
            if ((num - pre) * cur < 0){
                res = Math.max(res, r - l + 1);
                cur = (num - pre) / (int)Math.abs(num - pre);
            }
            else {
                if (num == pre) cur = 0;
                else {
                    cur = (num - pre) / (int)Math.abs(num - pre);
                    res = Math.max(res, 2);
                }
                l = r - 1;
            }
            r++;
        }
        return res;
    }
}

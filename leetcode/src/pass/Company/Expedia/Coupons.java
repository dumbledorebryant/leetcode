package pass.Company.Expedia;


public class Coupons {
    public int findMaxEvenSum(int[] val){
        int length = val.length;
        int ans = 0;
        int minOdd = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++){
            int num = val[i];
            if (num > 0) ans += num;
            if (Math.abs(num) % 2 == 1){
                minOdd = Math.min(minOdd, Math.abs(num));
            }
        }
        if (ans % 2 == 0) return ans;
        else return ans - minOdd;
    }

    public static void main(String[] args) {
        Coupons cp = new Coupons();
        int[] val = new int[]{2,3,6,-5,10,1,1};
        System.out.println(cp.findMaxEvenSum(val));
    }
}

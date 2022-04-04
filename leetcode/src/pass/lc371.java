package pass;

public class lc371 {
    public int getSum(int a, int b) {
        int carry = 0;
        int ans = 0;
        for (int i = 0; i < 32; i++){
            int x = (a >> i) & 1;
            int y = (b >> i) & 1;
            boolean l = (x == 1);
            boolean r = (y == 1);
            boolean c = (carry == 1);
            if ((l && r) || (l & c) || (r & c)){
                if (x == 1 && y == 1 && carry == 1){
                    ans |= (1 << i);
                }
                carry = 1;
            }
            else {
                if (x == 0 && y == 0 && carry == 0){}
                else {
                    ans |= (i << i);
                }
                carry = 0;
            }
        }
        return ans;
    }
}

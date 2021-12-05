package pass;

public class lc326 {
    public boolean isPowerOfThree(int n) {
        if (n==1)return true;
        if(n<3) return false;

        while(n != 1){
            if(n%3 != 0) return false;
            else n=n/3;
        }
        return true;
    
    }
}

package pass;

public class lc50 {
    public double myPow(double x, int n) {
        if(n == 0)return 1;
        if(n == 1)return x;
        if(n < 0)x = 1/x;
        return pow(x, Math.abs(n));  
    }
    
    public double pow(double x , int n){
       if(n == 0){return 1;}
       double temp =  pow(x , n/2);
       double ans = temp * temp;
       if(n % 2 != 0)ans *= x;
       return ans; 
    }
}

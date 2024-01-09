package pass;

public class lc1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int sums[] = new int[A.length+1];
        
        for(int i=1;i<=A.length;i++)
            sums[i] = A[i-1]+sums[i-1];
        
        int maxLval = 0;
        int ans=0;
        for(int i=L;i<=A.length-M;i++)
        {
            maxLval = Math.max(maxLval,sums[i]-sums[i-L]);
            ans = Math.max(ans,sums[i+M]-sums[i]+maxLval);
        }
        int maxRval = 0 ;
        for(int i=M;i<=A.length-L;i++)
        {
            maxRval = Math.max(maxRval,sums[i]-sums[i-M]);
            ans = Math.max(ans,sums[i+L]-sums[i]+maxRval);
        }
        return ans;
    }
}

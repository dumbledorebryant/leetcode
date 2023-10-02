package pass;

public class lc1151 {
    public int minSwaps(int[] data) {
        int n = data.length;
        int sum = 0;
        
        //hold the sum of all the one's in the array
        //this sum will tell us what can be considered as 
        //the maximum window of the subarray
        //Now we need to find all the subarray of size "sum"
        for(int d : data){
            sum += d;
        }
        
        //find the sum of the very first window
        int window = 0;
        for(int i=0;i<sum;i++){
            window += data[i];
        }
        
        //next starting point of the second window
        int index = sum;
        
        //initial value of the result
        int res = sum - window;
        
        //now iterate through all window of size sum
        while(index < n){
            //shrink the window by substracting the left pointer
            window -= data[index-sum];
            
            //expand the window's sum by adding the right pointer
            window += data[index];
            
            //find the min diff between all one's present in data and
            //max number of one's present in any window of size "sum"
            //sum will always be less than or equal to size of array
            res = Math.min(res,sum-window);
            index++;
        }
        return res;
    }
}

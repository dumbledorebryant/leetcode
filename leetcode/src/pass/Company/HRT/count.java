package pass.Company.HRT;

public class count {
    int solution(String inputStr) {
        int[] arr = new int[26];
        for(int i = 0; i < inputStr.length(); i++){
            arr[inputStr.charAt(i) - 'a']++;
        } 
        int countOdd = 0;
        for(int count: arr){
            if(count % 2 == 1){
                countOdd++;
            }
        }
        if(countOdd == 0){
            return 27;
        }
        if(countOdd == 1 || countOdd == 2){
            return 2;
        }
            
        else{
            return 0;
        }
    }
}

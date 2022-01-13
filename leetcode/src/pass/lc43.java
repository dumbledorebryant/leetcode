package pass;

public class lc43 {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(),n2 = num2.length();
        int arr[] = new int[n1+n2];
        for(int i = n1-1;i>=0;i--){
            for(int j = n2-1;j>=0;j--){
                int c1 = num1.charAt(i) - '0';
                int c2 = num2.charAt(j) - '0';
                arr[i+j+1] += c1 * c2;
            }
        }
        
        int carry = 0;
        for(int i = arr.length-1;i>=0;i--){
            int temp = (arr[i] + carry) % 10;
            carry = (arr[i] + carry) / 10;
            arr[i] = temp;
        }
        StringBuilder res = new StringBuilder();
        for (int i : arr)res.append(i);
        while(res.length() > 0 && res.charAt(0) == '0') res.deleteCharAt(0);
        return res.length() == 0 ? "0" : res.toString();
    }
}

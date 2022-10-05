package pass.Company.Cisco;
import java.util.*;
public class IP {
    public static void main(String[] args){

        System.out.print(valid());
    }
    private static String valid(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        System.out.print(s);
        String[] arr = s.split("\\.");
        System.out.print(Arrays.toString(arr));
        if(arr.length != 4){
            return "INVALID";
        }
        for(String str : arr){
            System.out.print(str);
            if(str.length() == 0 || str.length() > 3){
                return "INVALID";

            }
            if(str.charAt(0) == '0' && str.length() != 1){
                return "INVALID";
            }
            if(Integer.parseInt(str) >= 255 || Integer.parseInt(str) <= 0){
                return "INVALID";
            }

        }
        return "VALID";
    }
}

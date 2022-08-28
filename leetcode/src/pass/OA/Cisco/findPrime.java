package pass.OA.Cisco;
import java.util.*;

public class findPrime {
    public static void main(String[] args){
        getPrime();
    }

    private static void getPrime(){
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        String[] strArr = line.split(" ");
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        for(int j : arr){
            if(checkPrime(j)){
                System.out.print("Prime ");
            }else{
                System.out.print("Composite ");
            }
        }
    }

    private static boolean checkPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++ ){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}

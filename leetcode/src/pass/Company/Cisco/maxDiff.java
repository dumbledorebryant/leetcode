package pass.Company.Cisco;

import java.io.IOException;
import java.util.Scanner;

public class maxDiff {
    public static void main(String[] args) throws IOException {
        maxDiff();
    }
    private static void maxDiff(){
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] strArr = s.split(" ");
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int maxDiff = arr[1] - arr[0];
        int min = arr[0];
        for(int i = 2; i < num; i++){
            if(arr[i] - min > maxDiff){
                maxDiff = arr[i] - min;
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.print(maxDiff);
    }
}

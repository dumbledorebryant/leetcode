package pass.OA.Cisco;
import java.util.Scanner;

public class countBit {
    public static void main(String[] args){
        count();
    }
    private static void count(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.parseInt(s);
        int count = 0;
        while(n > 0){
            n &= n - 1;
            count++;
        }
        System.out.print(count);
    }
}

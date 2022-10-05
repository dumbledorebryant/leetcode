package pass.Company.Cisco;
import java.util.*;

public class queenAttack {
    public static void main(String[] args){
        queenAttack();
    }
    private static void queenAttack(){
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String[] queen = line1.split(" ");
        int qx = Integer.parseInt(queen[0]);
        int qy = Integer.parseInt(queen[1]);
        String[] op = line2.split(" ");
        int ox = Integer.parseInt(op[0]);
        int oy = Integer.parseInt(op[1]);
        String res;
        if(qx == ox){
            res = "Yes";
        }
        else{
            if(qy == oy){
                res = "Yes";
            }else{
                if(Math.abs(qx - ox) == Math.abs(qy - oy)){
                    res = "Yes";
                }else{
                    res = "No";
                }
            }
        }
        System.out.print(res);
    }
}

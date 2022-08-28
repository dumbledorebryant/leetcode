package pass.OA.Cisco;

import java.util.*;

public class rotateMatrix {
    public static void main(String[] args){
        rotate();
    }
    private static void rotate(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.parseInt(s);
        int[][] m = new int[n][n];
        int num = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                m[i][j] = num++;
            }
        }
        for(int first = 0, last = n - 1; first < last; first++, last--){
            int[] temp = m[first];
            m[first] = m[last];
            m[last] = temp;
        }
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int tp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tp;
            }
        }
        System.out.print(Arrays.deepToString(m));

    };
}

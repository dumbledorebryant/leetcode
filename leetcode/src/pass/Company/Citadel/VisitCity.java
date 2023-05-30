package pass.Company.Citadel;

import java.util.Arrays;

public class VisitCity {
    public static void main(String[] args){
        int[] red = new int[]{2, 3, 4};
        int[] blue = new int[]{3, 1, 1};
        int blueCost = 2;
        int l = red.length;

        int r = 0;
        int b = blueCost;
        int c = 0;
        int[] result = new int[l + 1];
        result[0] = c;
        for(int i = 0; i < l; i++){
            int temp = r;
            r = Math.min(r + red[i], b + red[i]);
            b = Math.min(temp + blueCost + blue[i], b + blue[i]);
            c = Math.min(r, b);  
            result[i  + 1] = c;
        }

        System.out.println(Arrays.toString(result));
    }
}

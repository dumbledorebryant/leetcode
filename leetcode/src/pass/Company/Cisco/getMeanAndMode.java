package pass.Company.Cisco;
import java.util.*;

public class getMeanAndMode {
    public static void main(String[] args){
        getMeanAndMode();
    }

    private static void getMeanAndMode(){
        Scanner sc = new Scanner(System.in);
        int sum = 0, maxCount = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int num = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        /*
            此处如果用sc.nextInt（）读取数字的话 后面回车符不会被读取
            需要再用一个nextLine（）来读取
        int num = sc.nextInt();
        String blank = sc.nextLine();
        String line = sc.nextLine();

         */
        String[] arr = line.split(" ");
        for(String s : arr){
            int i = Integer.parseInt(s);
            sum += i;
            map.put(i, map.getOrDefault(i,0) + 1);
            if(map.get(i) > maxCount){
                maxCount = map.get(i);
                max = i;
            }
        }
        double mean = sum/((float) num);
        System.out.format("%.4f", mean);
        System.out.print(" " + max);

    }
}

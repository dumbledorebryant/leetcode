import java.util.Arrays;

public class App  {
    public static void main(String[] args) throws Exception 
    {
        System.out.println("Hi Zbn");
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        System.out.println(arr.toString());
        System.out.println(Arrays.asList(arr));
        
        //使用Array.toString()
        System.out.println(Arrays.toString(arr));
    }
}

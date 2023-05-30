package pass.Company.Citadel;
public class OddString {
    public static void main(String[] args){
        String[] arr = new String[]{"abc", "abcd"};

        int totalEven = 0;
        for(String s: arr){
            int l = s.length();
            for(int i = 0; i < l; i++){
                if((int)s.charAt(i) % 2 == 0){
                    totalEven++;
                    break;
                };
            }
        }
        int l = arr.length;

        if((l - totalEven) % 2 == 1){
            System.out.println("ODD");
        }
        else{
            System.out.println("EVEN");
        }

        
    }
}

package pass;

public class lc165 {
    public int compareVersion(String version1, String version2) {
        String[] list1 = version1.split("\\.");
        String[] list2 = version2.split("\\.");
        int len1 = list1.length;
        int len2 = list2.length;
        int len = Math.min(len1, len2);
        for (int i = 0; i < len; i++){
            String s1 = list1[i];
            String s2 = list2[i];
            int num1 = Integer.valueOf(s1);
            int num2 = Integer.valueOf(s2);
            if (num1 > num2) return 1;
            else if (num1 < num2) return -1;
        }
        if (len1 == len){
            for (int i = len; i < len2; i++){
                String s = list2[i];
                int num = Integer.valueOf(s);
                if (num != 0) return -1;
            }
        }
        if (len2 == len){
            for (int i = len; i < len1; i++){
                String s = list1[i];
                int num = Integer.valueOf(s);
                if (num != 0) return 1;
            }
        }
        return 0;
    }
}

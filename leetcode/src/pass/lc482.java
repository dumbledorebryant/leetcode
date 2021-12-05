package pass;

public class lc482 {
    public String licenseKeyFormatting(String s, int k) {
        String[] items = s.split("-");
        int length = items.length;
        if (length == 1) {
            String single = items[0].toUpperCase();
            if (single.length() < k){
                return single;
            }
        }

        String all = "";
        for (int i = 0; i < length; i++){
            all += items[i];
        }
        all = all.toUpperCase();
        int len = all.length();
        if (len == 0) return "";
        if (k == len) return all;

        int first = (len % k  == 0) ? k : len % k;

        String ans = "";
        int i = 0;
        while (i < first){
            ans += all.charAt(i++);
        }
        ans += "-";
        while (i < len){
            if (i == len - k){
                while (i < len) ans += all.charAt(i++);
                break;
            }
            else {
                for (int j = 0; j < k; j++){
                    ans += all.charAt(i++);
                }
                ans += "-";
            }
        }
        return ans;
    }
}

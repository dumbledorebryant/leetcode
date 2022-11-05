package pass;

public class lc468 {
    public String validIPAddress(String queryIP) {
        if (queryIP.split(":").length == 1){
            String[] nums = queryIP.split("\\.", -1);
            if (nums.length != 4) return "Neither";
            for (String x : nums) {
                // Validate integer in range (0, 255):
            
                // 1. length of chunk is between 1 and 3
                if (x.length() == 0 || x.length() > 3) return "Neither";
            
                // 2. no extra leading zeros
                if (x.charAt(0) == '0' && x.length() != 1) return "Neither";
      
                // 3. only digits are allowed
                for (char ch : x.toCharArray()) {
                    if (! Character.isDigit(ch)) return "Neither";
                }
            
                // 4. less than 255
                if (Integer.parseInt(x) > 255) return "Neither";
            }
            return "IPv4";
        }
        else {
            String[] words = queryIP.split(":");
            if (words.length != 8) return "Neither";
            if (queryIP.charAt(queryIP.length() - 1) == ':') return "Neither";
            for (String x : words){
                if (x.length() == 0 || x.length() > 4) return "Neither";
                for (char ch : x.toCharArray()){
                    if (!Character.isDigit(ch)){
                        if (Character.isAlphabetic(ch)){
                            if ((ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')){}
                            else return "Neither";
                        }
                        else return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}

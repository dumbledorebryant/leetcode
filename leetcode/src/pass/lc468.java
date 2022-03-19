package pass;

public class lc468 {
    public String validIPAddress(String queryIP) {
        String[] nums = queryIP.split("\\.", -1);
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
}

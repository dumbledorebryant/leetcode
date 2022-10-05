package pass.Company.Palantir.Karat;

import java.util.*;
public class WordProcessor {
    public List<String> reflow(List<String> lines, int length){
        String w = lines.get(0);
        for (int i = 1; i < lines.size(); i++){
            w += " ";
            w += lines.get(i);
        }
        String[] words = w.split(" ");
        
        List<String> ans = new ArrayList<>();
        int size = words.length;
        int i = 0;
        while (i < size){
            int remain = length;
            int count = 0;
            while (i < size){
                if (remain - words[i].length() < 0){
                    break;
                }
                count++;
                remain -= words[i].length() + 1;
                i++;
            }

            List<String> line = new ArrayList<>();
            
            int len = 0;
            for (int j = i - count; j < i; j++){
                String tmp = words[j];
                len += tmp.length();
                line.add(tmp);
            }
            if (line.size() == 1){
                ans.add(line.get(0));
                return ans;
            }
            if (line.size() == 0){
                return ans;
            }

            char[] chars = new char[(length - len) / (line.size() - 1)];
            Arrays.fill(chars, '-');
            String dashes = new String(chars);
            String reflowed = "";
            int extra = (length - len) % (line.size() - 1);
            for (int j = 0; j < line.size(); j++){
                if (j == line.size() - 1) reflowed += line.get(j);
                else {
                    reflowed += (line.get(j) + dashes);
                    if (extra > 0){
                        extra--;
                        reflowed += "-";
                    }
                }
            }
            ans.add(reflowed);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("The day began as still as the");
        lines.add("night abruptly lighted with");
        lines.add("brilliant flame");
        WordProcessor wp = new WordProcessor();
        System.out.println(wp.reflow(lines, 24));
    }
}

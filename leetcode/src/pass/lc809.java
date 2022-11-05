package pass;

public class lc809 {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        char[] cs = s.toCharArray();
        int m = cs.length;
        for (String word : words){
            char[] cw = word.toCharArray();
            int n = cw.length;
            int i = 0; 
            int j = 0;
            while (i < m && j < n){
                char a = cs[i];
                char b = cw[j];
                int cnta = 0;
                int cntb = 0;
                if (a == b){
                    int nexta = i;
                    while (nexta < m && cs[nexta] == a){
                        nexta++;
                    }
                    cnta = nexta - i;
                    int nextb = j;
                    while (nextb < n && cw[nextb] == b){
                        nextb++;
                    }
                    cntb = nextb - j;
                    if (cnta < cntb) break;
                    if (cnta > cntb) {
                        if (cnta >= 3){
                            i = nexta;
                            j = nextb;
                        }
                        else break;
                    }
                    if (cnta == cntb) {
                        i = nexta;
                        j = nextb;
                    }
                }
                else break;
            }
            if (i == m && j == n) ans++;
        }
        return ans;
    }
}

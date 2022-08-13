package pass.OA.Amazon;

class abcmaxcount {     
    public int find(String s) {         
        int[] cnt = new int[26];         
        int[] resCnt = new int[26];         
        int curMax = 0, res = 0;         
        for(char c : s.toCharArray()){             
            int cur = (int)(c - 'a');             
            cnt[cur]++;             
            curMax = Math.max(cnt[cur], curMax);             
            for(int i=0;i<26;i++){                 
                if(cnt[i] == curMax){                     
                    resCnt[i]++;                     
                    res = Math.max(res, resCnt[i]);                 
                }             
            }         
        }         
        return res;     
    } 
}

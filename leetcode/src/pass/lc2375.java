package pass;

class Solution {
    String pat, res = "";
    boolean[] vis = new boolean[10];

    public String smallestNumber(String pattern) {
        this.pat = pattern;
        for(int i=1; i<10; i++){
            if(dfs(i, 0, i+"")) break;
            vis[i] = false;
        }
        return res;
    }

    boolean dfs(int last, int idx, String s) {
        if(idx==pat.length()) {
            res = s; return true;
        }
        vis[last] = true;
        boolean flag = pat.charAt(idx)=='I';

        int start = flag ? last + 1 : 1;
        int end = flag ? 9 : last - 1;
        for(int i = start; i <= end; i++){
            if(vis[i]) continue;
            if(dfs(i, idx+1, s+i)) return true;
            vis[i] = false;
        }
        return false;
    }
}
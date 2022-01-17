package pass;

public class lc855 {
    int[] seats;
    int num = 0;
    int len;
    public lc855(int n) {
        len = n;
        seats = new int[n];
    }
    
    public int seat() {
        if (num == 0) {
            num++;
            seats[0] = 1;
            return 0;
        }
        num++;
        int dis = 0;
        int count = 0;
        int start = -1;
        int i = 0;
        for (; i < len; i++){
            int ppl = seats[i];
            if (ppl == 0){
                count++;
            }
            if (ppl == 1){
                if (count > dis){
                    count = 0;
                    start = i - count - 1;
                    dis = count;
                }
            }
        }
        if (seats[len - 1] == 0) {
            if (count > dis){
                count = 0;
                start = i - count - 1;
                dis = count;
            }
        }
        if (start == -1) {
            seats[0] = 1;
            return 0;
        }
        else{
            if (dis % 2 == 0) {
                seats[start + (dis / 2)] = 1;
                return start + (dis / 2);
            }
            else {
                seats[start + (dis / 2) + 1] = 1;
                return start + (dis / 2) + 1;
            }
        }
            
    }
    
    public void leave(int p) {
        num--;
        seats[p] = 0;
    }
}

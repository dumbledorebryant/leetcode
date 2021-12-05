package pass;
public class lc292 {
    public boolean canWinNim(int n) {
        return winNim(n, 1);
    }

    public boolean winNim(int n, int flag){
        if (n == 4 && flag == 0) return true;
        if (n < 4 && flag == 0) return false;
        if (n == 4 && flag == 1) return false;
        if (n < 4 && flag == 1) return true;
        boolean flaga = winNim(n - 1, 1 - flag);
        boolean flagb = winNim(n - 2, 1 - flag);
        boolean flagc = winNim(n - 3, 1 - flag);
        if (flag == 0) return flaga && flagb && flagc;
        else return flaga || flagb || flagc;
    }

    public boolean easyCanWinNim(int n) {
        return n % 4 != 0;
    }
}

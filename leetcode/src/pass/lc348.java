package pass;

public class lc348 {
    int[] auxRow;
    int[] auxCol;
    int dia = 0;
    int anti_dia = 0;
    int n;
    public lc348(int n) {
        auxRow = new int[n];
        auxCol = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        if (player == 1){
            auxRow[row]++;
            auxCol[col]++;
            if (row == col) dia++;
            if (row + col == n - 1) anti_dia++;
            if (auxRow[row] == n || auxCol[col] == n || dia == n || anti_dia == n) return 1;
        }
        else {
            auxRow[row]--;
            auxCol[col]--;
            if (row == col) dia--;
            if (row + col == n - 1) anti_dia--;
            if (auxRow[row] == -n || auxCol[col] == -n || dia == -n || anti_dia == -n) return 2;
        }
        return 0;
    }
}

package pass;
import java.util.*;
public class lc353 {
    LinkedList<Integer> body = new LinkedList<>();

    HashSet<Integer> set = new HashSet<>();

    LinkedList<Integer> food = new LinkedList<>();

    int m, n;

    boolean alive = true;

    public lc353(int width, int height, int[][] food) {
        this.n = width;
        this.m = height;

        set.add(encode(0, 0));
        body.addFirst(encode(0, 0));
        for (int[] p : food){
            this.food.addLast(encode(p[0], p[1]));
        }
    }

    private int encode(int a, int b){
        return a * n + b;
    }
    
    public int move(String direction) {
        if (!alive) return -1;

        int head = body.getFirst();
        int x = head / n; 
        int y = head % n;

        switch (direction) {
            case "U":
                x--;
                break;
            case "D":
                x++;
                break;
            case "L":
                y--;
                break;
            case "R":
                y++;
                break;
            
        }

        int next = encode(x, y);
        if (x < 0 || x >= m || y < 0 || y >= n){
            alive = false;
            return -1;
        }

        body.addFirst(next);
        if (!food.isEmpty() && food.getFirst() == next){
            food.removeFirst();
        } else {
            set.remove(body.removeLast());
        }

        if (set.contains(next)) {
            alive = false;
            return -1;
        }

        set.add(next);
        return body.size() - 1;
    }
}

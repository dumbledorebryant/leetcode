package pass;
import java.util.*;
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}

public class lc489 {
    int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(0, 0, visited, 0, robot);  
    }
    private void dfs(int x, int y, Set<String> visited, int curDir, Robot robot) {
        visited.add(x + "+" + y);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = i + curDir;
            int[] newPoint = dirs[nextDir % 4];
            int newx = x + newPoint[0];
            int newy = y + newPoint[1];
            String pos = newx + "+" + newy;
            if (!visited.contains(pos) && robot.move()) {
                dfs(newx, newy, visited, nextDir, robot);
                goback(robot);
            }
            
            robot.turnRight();
        }
    }
    
    private void goback(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}

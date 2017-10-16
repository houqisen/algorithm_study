import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinceIslands {
    // 4 directions: prev, next, up, down
    static final int[][] DIR = { 
        {0, -1}, {0, 1}, {-1, 0}, {1, 0} };

    public static void main(String...args) {
        int [][] grid = {
            {1,1,0,0,0}, {1,1,0,0,0}, {0,0,0,1,1}, {0,0,0,1,1} };

        System.out.println(numDistinctIslands(grid));
    }

    private static int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        int res = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid.length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    helper(grid, i, j, 0, 0, sb);
                    String s = sb.toString();
                    if (!set.contains(s)) {
                        res ++;
                        set.add(s);
                    }
                }
            }
        }

        return res;
    }

    private static void helper(int[][] grid, int i, int j, int x, int y, StringBuilder sb) {
        //set this point to other value so that it won't be re-accessed
        grid[i][j] = 2;

        sb.append(x + "" + y);
        for(int[] d : DIR) {
            int row = i+d[0];
            int col = j+d[1];

            //overflow or has been accessed
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
                continue;
            }
            helper(grid, row, col, x+d[0], y+d[1], sb);
        }
    }
}
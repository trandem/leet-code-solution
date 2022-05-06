package problems;

import java.util.Arrays;

/**
 * You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix.
 * <p>
 * Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).
 * <p>
 * At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.
 * <p>
 * <p>
 * <p>
 * Input: grid = [[2,5,4],[1,5,1]]
 * Output: 4
 * Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
 * The cells visited by the first robot are set to 0.
 * The second robot will collect 0 + 0 + 4 + 0 = 4 points.
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[3,3,1],[8,5,2]]
 * Output: 4
 * Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
 * The cells visited by the first robot are set to 0.
 * The second robot will collect 0 + 3 + 1 + 0 = 4 points.
 * Example 3:
 * <p>
 * <p>
 * Input: grid = [[1,3,1,15],[1,3,3,1]]
 * Output: 7
 * Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
 * The cells visited by the first robot are set to 0.
 * The second robot will collect 0 + 1 + 3 + 3 + 0 = 7 points.
 */
public class GridGame {
    public static long gridGame(int[][] g) {

        long bottom = Arrays.stream(g[1]).sum();
        long top = g[0][0];
        int indexDown = 0;
        long currentMax = bottom+top;

        for (int i = 1; i < g[0].length; i++) {
            bottom -= g[1][i-1];
            top += g[0][i];
            long valueGoDown = top + bottom;
            if (currentMax < valueGoDown) {
                currentMax = valueGoDown;
                indexDown = i;
            }
        }
        System.out.println(currentMax);
        System.out.println(indexDown);
        int totalUp =0;
        for(int i =indexDown+1; i< g[0].length;i++){
            totalUp += g[0][i];
        }
        int totalDown =0;
        for (int i = 0; i< indexDown; i++){
            totalDown += g[1][i];
        }

        return Math.max(totalDown, totalUp);
    }

    public static void main(String[] args) {
        int[][] g ={{2,5,4},{1,5,1}};
        int[][] g1 ={{3,3,1},{8,5,2}};
        int[][] g3 ={{20, 3,20,17, 2,12,15,17, 4,15},
                     {20,10,13,14,15, 5, 2, 3,14, 3}};
        System.out.println(gridGame(g3));

    }
}

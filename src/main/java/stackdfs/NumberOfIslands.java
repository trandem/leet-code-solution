package stackdfs;

/**
 * Number of Islands
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int num = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    num++;
                    dfsRecursion(i, j, visited, grid);
                }
            }
        }
        return num;
    }

    public static void dfsRecursion(int i, int j, boolean[][] visited, char[][] grid) {
        visited[i][j] = true;

        if (j + 1 < grid[0].length && grid[i][j+1] == '1' && !visited[i][j+1]) {
            dfsRecursion(i , j+1, visited, grid);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            dfsRecursion(i, j - 1, visited, grid);
        }

        if (i + 1 < grid.length && grid[i + 1][j] == '1' && !visited[i + 1][j]){
            dfsRecursion(i + 1, j , visited, grid);
        }

        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            dfsRecursion(i - 1, j, visited, grid);
        }
    }

    public static void main(String[] args) {
        char[][] islands = {{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};


        System.out.println(numIslands(islands));
    }
}

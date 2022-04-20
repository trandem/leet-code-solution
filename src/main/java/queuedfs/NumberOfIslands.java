package queuedfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int num = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    num++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return num;
    }

    public void bfs(int i, int j, boolean[][] visited, char[][] grid) {
        Queue<Point> pointQueue = new LinkedList<>();

        Point root = new Point(i, j);
        pointQueue.add(root);

        while (!pointQueue.isEmpty()) {
            Point point = pointQueue.poll();
            int x = point.x;
            int y = point.y;
            if (grid[x][y] != '1' || visited[x][y]) continue;

            visited[x][y] = true;

            if (x - 1 >= 0 && !visited[x - 1][y]) pointQueue.add(new Point(x - 1, y));
            if (y - 1 >= 0 && !visited[x][y - 1]) pointQueue.add(new Point(x, y - 1));
            if (x + 1 < grid.length && !visited[x + 1][y]) pointQueue.add(new Point(x + 1, y));
            if (y + 1 < grid[0].length && !visited[x][y + 1]) pointQueue.add(new Point(x, y + 1));
        }

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

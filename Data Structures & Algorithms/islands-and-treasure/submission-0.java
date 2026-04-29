class Solution {
    private static int INF = Integer.MAX_VALUE;
    private record Pair(int x, int y) {}
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        Deque<Pair> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == INF) {
                    int dist = bfs(grid, i, j, m, n, dir);
                    grid[i][j] = dist;
                }
            }
        }
    }

    private int bfs(int[][] grid, int i, int j, int m, int n, int[][] dir) {
        Deque<Pair> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        q.offer(new Pair(i, j));
        visited[i][j] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Pair curr = q.poll();

                int x = curr.x(), y = curr.y();

                if (grid[x][y] == 0)
                    return steps;

                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]
                        && grid[nx][ny] != -1) {
                        visited[nx][ny] = true;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
            steps++;
        }
        return INF;
    }
}

class Solution {
    private record Pair(int x, int y) {}
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Deque<Pair> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int x = curr.x(), y = curr.y();

                for (int[] d : dir) {
                    int nx = x + d[0], ny = y + d[1];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == INF) {
                        grid[nx][ny] = grid[x][y] + 1;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}

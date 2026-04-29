class Solution {
    private record Pair(int x, int y) {}
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
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
            Pair curr = q.poll();

            for (int[] d : dir) {
                int nx = curr.x() + d[0];
                int ny = curr.y() + d[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == Integer.MAX_VALUE) {
                    grid[nx][ny] = grid[curr.x()][curr.y()] + 1;
                    q.offer(new Pair(nx, ny));
                }
            }
        }
    }
}

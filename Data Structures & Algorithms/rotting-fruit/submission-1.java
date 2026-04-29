class Solution {
    private record Pair(int x, int y) {}
    public int orangesRotting(int[][] grid) {
        int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        int m = grid.length, n = grid[0].length;

        Deque<Pair> q = new ArrayDeque<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int time = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Pair curr = q.poll();

                int x = curr.x(), y = curr.y();

                for (int[] d : dir) {
                    int nx = x + d[0], ny = y + d[1];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        q.offer(new Pair(nx, ny));
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}

class Solution {
    private record Pair(int x, int y, int t) {}
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.t() - b.t());
        pq.offer(new Pair(0, 0, grid[0][0]));

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int x = curr.x();
            int y = curr.y();
            int t = curr.t();

            if (visited[x][y])
                continue;

            visited[x][y] = true;

            if (x == n - 1 && y == n - 1)
                return t;

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int newTime = Math.max(t, grid[nx][ny]);
                    pq.offer(new Pair(nx, ny, newTime));
                }
            }
        }

        return -1;
    }
}

class Solution {
    private record Pair(int x, int y) {}
    public int numIslands(char[][] grid) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = grid.length, n = grid[0].length;

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;

                    Deque<Pair> q = new ArrayDeque<>();
                    q.offer(new Pair(i, j));
                    grid[i][j] = '0';

                    while (!q.isEmpty()) {
                        Pair curr = q.poll();

                        for (int[] d : dir) {
                            int nx = curr.x() + d[0];
                            int ny = curr.y() + d[1];
                            if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == '1') {
                                q.offer(new Pair(nx, ny));
                                grid[nx][ny] = '0';
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}

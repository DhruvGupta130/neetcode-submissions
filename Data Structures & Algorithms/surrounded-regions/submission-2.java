class Solution {
    private record Pair(int x, int y) {}
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        Deque<Pair> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            q.offer(new Pair(i, 0));
            q.offer(new Pair(i, n - 1));
        }

        for (int j = 0; j < n; j++) {
            q.offer(new Pair(0, j));
            q.offer(new Pair(m - 1, j));
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x(), y = curr.y();

            if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'O')
                continue;

            board[x][y] = '#';

            q.offer(new Pair(x + 1, y));
            q.offer(new Pair(x - 1, y));
            q.offer(new Pair(x, y + 1));
            q.offer(new Pair(x, y - 1));
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
}

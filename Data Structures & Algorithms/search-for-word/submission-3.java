class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m == 0 || n == 0)
            return false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, m, n, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int m, int n, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }

        if (i >= m || j >= n || i < 0 || j < 0 || board[i][j] != word.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(i + 1, j, m, n, index + 1, board, word)
            || dfs(i - 1, j, m, n, index + 1, board, word)
            || dfs(i, j + 1, m, n, index + 1, board, word)
            || dfs(i, j - 1, m, n, index + 1, board, word);

        board[i][j] = temp;
        return found;
    }
}

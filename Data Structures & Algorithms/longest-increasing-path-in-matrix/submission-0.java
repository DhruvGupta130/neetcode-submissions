class Solution {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] d : dp) Arrays.fill(d, -1);

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, calculate(matrix, i, j, dp));
            }
        }
        return max;
    }

    private int calculate(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != -1)
            return dp[i][j];

        int max = 1;

        for (int d[] : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && nj >= 0 && ni < matrix.length && nj < matrix[0].length
                && matrix[ni][nj] > matrix[i][j]) {
                max = Math.max(max, 1 + calculate(matrix, ni, nj, dp));
            }
        }
        return dp[i][j] = max;
    }
}

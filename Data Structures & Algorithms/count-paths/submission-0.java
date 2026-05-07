class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] d : dp) Arrays.fill(d, -1);
        return calculate(m - 1, n - 1, dp);
    }

    private int calculate(int m, int n, int[][] dp) {
        if (m < 0 || n < 0)
            return 0;
        if (m == 0 && n == 0)
            return 1;

        if (dp[m][n] != -1)
            return dp[m][n];

        return dp[m][n] = calculate(m - 1, n, dp) + calculate(m, n - 1, dp);
    }
}

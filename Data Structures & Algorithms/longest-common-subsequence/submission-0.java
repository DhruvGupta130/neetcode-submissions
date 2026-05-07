class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] d : dp) Arrays.fill(d, -1);
        return calculate(s.toCharArray(), 0, t.toCharArray(), 0, dp);
    }

    private int calculate(char[] c, int i, char[] d, int j, int[][] dp) {
        if (i >= c.length || j >= d.length)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (c[i] == d[j])
            return dp[i][j] = 1 + calculate(c, i + 1, d, j + 1, dp);

        else
            return dp[i][j] = Math.max(calculate(c, i + 1, d, j, dp), calculate(c, i, d, j + 1, dp));
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        char[] c = s.toCharArray();
        int m = c.length;
        char[] d = t.toCharArray();
        int n = d.length;

        Integer[][] dp = new Integer[m][n];

        return calculate(c, m - 1, d, n - 1, dp);
    }
    private int calculate(char[] c, int i, char[] d, int j, Integer[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        if (c[i] == d[j]) {
            return dp[i][j] = calculate(c, i - 1, d, j - 1, dp) + calculate(c, i - 1, d, j, dp);
        }
        return dp[i][j] = calculate(c, i - 1, d, j, dp);
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        char[] c = word1.toCharArray();
        int m = c.length;
        char[] d = word2.toCharArray();
        int n = d.length;

        Integer[][] dp = new Integer[m][n];
        return calculate(c, m - 1, d, n - 1, dp);
    }

    public int calculate(char[] c, int i, char[] d, int j, Integer[][] dp) {
        if (i < 0)
            return j + 1;

        if (j < 0)
            return i + 1;

        if (dp[i][j] != null)
            return dp[i][j];

        if (c[i] == d[j]) {
            return dp[i][j] = calculate(c, i - 1, d, j - 1, dp);
        }

        int insert = calculate(c, i, d, j - 1, dp);
        int delete = calculate(c, i - 1, d, j, dp);
        int replace = calculate(c, i - 1, d, j - 1, dp);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}

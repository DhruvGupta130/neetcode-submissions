class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0, dp);
    }

    private boolean dfs(String s, String p, int i, int j, Boolean[][] dp) {
        if (j == p.length())
            return i == s.length();

        if (dp[i][j] != null)
            return dp[i][j];

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean ans;

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            ans = dfs(s, p, i, j + 2, dp) || (match && dfs(s, p, i + 1, j, dp));
        } else {
            ans = match && dfs(s, p, i + 1, j + 1, dp);
        }

        return dp[i][j] = ans;
    }
}
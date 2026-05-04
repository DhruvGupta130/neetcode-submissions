class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return dfs(0, s, set, dp);
    }

    private boolean dfs(int i, String s, Set<String> set, Boolean[] dp) {
        if (i == s.length())
            return true;

        if (dp[i] != null)
            return dp[i];

        for (int j = i + 1; j <= s.length(); j++) {
            if (set.contains(s.substring(i, j)) && dfs(j, s, set, dp)) {
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
}

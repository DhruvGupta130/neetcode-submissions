class Solution {
    private int[] dp = new int[101];
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(check(cost.length - 2, cost), check(cost.length - 1, cost));
    }

    private int check(int n, int[] cost) {
        if (n == 0 || n == 1)
            return dp[n] = cost[n];

        if (dp[n] != 0)
            return dp[n];
        return dp[n] = cost[n] + Math.min(check(n - 1, cost), check(n - 2, cost));
    }
}
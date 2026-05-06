class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return calculate(nums, 0, -1, dp);
    }

    private int calculate(int[] nums, int i, int p, int[][] dp) {
        if (i >= nums.length)
            return 0;

        if (dp[i][p + 1] != -1)
            return dp[i][p + 1];

        int take = 0;
        if (p == -1 || nums[i] > nums[p]) {
            take = 1 + calculate(nums, i + 1, i, dp);
        }

        int skip = calculate(nums, i + 1, p, dp);
        return dp[i][p + 1] = Math.max(take, skip);
    }
}

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return process(n - 1, nums, dp);
    }

    private int process(int n, int[] nums, int[] dp) {
        if (n == 0)
            return dp[0] = nums[0];
        if (n == 1)
            return dp[1] = Math.max(nums[0], nums[1]);

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = Math.max(process(n - 1, nums, dp), nums[n] + process(n - 2, nums, dp));
    }
}

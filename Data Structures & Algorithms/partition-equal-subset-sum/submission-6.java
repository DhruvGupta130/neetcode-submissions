class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1)
            return false;

        int n = nums.length;
        Boolean[][] dp = new Boolean[n][sum];
        return calculate(nums, 0, sum / 2, dp);
    }

    private boolean calculate(int[] nums, int i, int target, Boolean[][] dp) {
        if (target == 0)
            return true;
        if (i >= nums.length || target < 0)
            return false;

        if (dp[i][target] != null)
            return dp[i][target];

        return dp[i][target] = calculate(nums, i + 1, target, dp)
            || calculate(nums, i + 1, target - nums[i], dp);
    }
}

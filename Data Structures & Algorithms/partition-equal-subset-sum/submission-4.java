class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // Odd sum cannot be equally partitioned
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return check(nums, 0, target, dp);
    }

    private boolean check(int[] nums, int i, int target, Boolean[][] dp) {
        // Found subset
        if (target == 0)
            return true;

        // Invalid state
        if (i >= nums.length || target < 0)
            return false;

        // Already computed
        if (dp[i][target] != null)
            return dp[i][target];

        // Take current element
        boolean take = check(nums, i + 1, target - nums[i], dp);

        // Skip current element
        boolean skip = check(nums, i + 1, target, dp);

        return dp[i][target] = take || skip;
    }
}
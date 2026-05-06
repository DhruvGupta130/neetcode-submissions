class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        boolean[] dp = new boolean[nums.length];
        return check(nums, 0, target, dp);
    }

    private boolean check(int[] nums, int i, int target, boolean[] dp) {
        if (target == 0)
            return true;

        if (i >= nums.length || target < 0)
            return false;

        return dp[i] = check(nums, i + 1, target - nums[i], dp) || check(nums, i + 1, target, dp);
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return check(nums, nums.length - 1, dp);
    }

    private boolean check(int[] nums, int i, Boolean[] dp) {
        if (i <= 0)
            return true;

        if (dp[i] != null)
            return dp[i];

        for (int j = 0; j < i; j++) {
            if (j + nums[j] >= i) {
                if (check(nums, j, dp)) {
                    return dp[i] = true;
                }
            }
        }
        return dp[i] = false;
    }
}
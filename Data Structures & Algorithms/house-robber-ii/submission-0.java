class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(
            solve(nums, n - 2, 0, new int[n]),
            solve(nums, n - 1, 1, new int[n])
        );
    }

    private int solve(int[] nums, int i, int start, int[] dp) {
        if (i < start) return 0;
        if (i == start) return nums[i];

        if (dp[i] != 0) return dp[i];

        return dp[i] = Math.max(
            solve(nums, i - 1, start, dp),
            nums[i] + solve(nums, i - 2, start, dp)
        );
    }
}
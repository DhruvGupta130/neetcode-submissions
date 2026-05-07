class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(calculate(nums, i, dp), max);
        }
        return max;
    }

    private int calculate(int[] nums, int i, int[] dp) {
        if (dp[i] != -1)
            return dp[i];

        int maxLen = 1;

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                maxLen = Math.max(maxLen, 1 + calculate(nums, j, dp));
            }
        }
        return dp[i] = maxLen;
    }
}

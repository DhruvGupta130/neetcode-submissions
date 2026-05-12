class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) arr[i + 1] = nums[i];
        Integer[][] dp = new Integer[n + 2][n + 2];
        return calculate(arr, 1, n, dp);
    }

    private int calculate(int[] arr, int left, int right, Integer[][] dp) {
        if (left > right)
            return 0;

        if (dp[left][right] != null)
            return dp[left][right];

        int max = 0;

        for (int i = left; i <= right; i++) {
            int coins = arr[left - 1] * arr[i] * arr[right + 1] + calculate(arr, left, i - 1, dp)
                + calculate(arr, i + 1, right, dp);

            max = Math.max(max, coins);
        }
        return dp[left][right] = max;
    }
}

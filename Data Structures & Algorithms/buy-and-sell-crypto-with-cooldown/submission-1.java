class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return calculate(prices, 0, 1, dp);
    }

    private int calculate(int[] prices, int i, int canBuy, Integer[][] dp) {
        if (i >= prices.length)
            return 0;

        if (dp[i][canBuy] != null)
            return dp[i][canBuy];

        if (canBuy == 1) {
            int buy = -prices[i] + calculate(prices, i + 1, 0, dp);
            int skip = calculate(prices, i + 1, 1, dp);
            return dp[i][canBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[i] + calculate(prices, i + 2, 1, dp);
            int hold = calculate(prices, i + 1, 0, dp);
            return dp[i][canBuy] = Math.max(sell, hold);
        }
    }
}

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return calculate(s.toCharArray(), n - 1, dp);
    }

    private int calculate(char[] c, int n, int[] dp) {
        if (n < 0)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        int ways = 0;

        if (c[n] != '0') {
            ways = calculate(c, n - 1, dp);
        }

        if (n > 0) {
            int num = (c[n - 1] - '0') * 10 + (c[n] - '0');
            if (num >= 10 && num <= 26) {
                ways += calculate(c, n - 2, dp);
            }
        }

        return dp[n] = ways;
    }
}
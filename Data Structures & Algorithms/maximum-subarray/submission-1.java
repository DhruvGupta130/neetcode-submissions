class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = nums[0];

        for (int n : nums) {
            sum += n;

            maxSum = Math.max(maxSum, sum);

            if (sum < 0)
                sum = 0;
        }

        return maxSum;
    }
}

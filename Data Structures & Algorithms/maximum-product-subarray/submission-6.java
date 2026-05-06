class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int temp = max;
            max = Math.max(n, Math.max(n * min, n * max));
            min = Math.min(n, Math.min(n * min, n * temp));
            res = Math.max(res, max);
        }
        return res;
    }
}

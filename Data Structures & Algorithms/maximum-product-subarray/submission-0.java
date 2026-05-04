class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = max;

            max = Math.max(curr, Math.max(curr * max, curr * min));
            min = Math.min(curr, Math.min(curr * tempMax, curr * min));
            result = Math.max(result, max);
        }
        return result;
    }
}

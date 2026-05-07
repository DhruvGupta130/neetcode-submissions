class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return calculate(nums, nums.length - 1, target, dp);
    }

    private int calculate(int[] nums, int i, int target, Map<String, Integer> dp) {
        if (i < 0)
            return target == 0 ? 1 : 0;
            
        String key = i + "," + target;

        if (dp.containsKey(key))
            return dp.get(key);

        int positive = calculate(nums, i - 1, target - nums[i], dp);

        int negative = calculate(nums, i - 1, target + nums[i], dp);

        dp.put(key, positive + negative);

        return dp.get(key);
    }
}

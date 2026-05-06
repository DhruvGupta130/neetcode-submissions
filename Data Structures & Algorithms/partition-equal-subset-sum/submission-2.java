class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        return check(nums, 0, target);
    }

    private boolean check(int[] nums, int i, int target) {
        if (target == 0)
            return true;

        if (i >= nums.length || target < 0)
            return false;

        return check(nums, i + 1, target - nums[i]) || check(nums, i + 1, target);
    }
}

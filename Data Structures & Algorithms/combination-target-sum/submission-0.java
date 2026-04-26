class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0, nums, new ArrayList<>(), target, res);
        return res;
    }

    private void backTrack(
        int index, int[] nums, List<Integer> curr, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0)
            return;

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);

            backTrack(i, nums, curr, target - nums[i], res);

            curr.removeLast();
        }
    }
}

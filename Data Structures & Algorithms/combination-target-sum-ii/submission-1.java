class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0, candidates, new ArrayList<>(), target, res);
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
            if (i > index && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > target)
                break;

            curr.add(nums[i]);

            backTrack(i + 1, nums, curr, target - nums[i], res);

            curr.removeLast();
        }
    }
}

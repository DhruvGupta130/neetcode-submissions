class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(
        int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            curr.add(nums[i]);
            used[i] = true;

            backTrack(nums, used, curr, res);

            curr.removeLast();
            used[i] = false;
        }
    }
}

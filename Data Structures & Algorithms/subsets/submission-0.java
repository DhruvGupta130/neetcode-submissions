class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        process(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void process(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);

            process(i + 1, nums, curr, res);

            curr.removeLast();
        }
    }
}

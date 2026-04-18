class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];

        left[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[nums.length] = 1;
        for (int j = nums.length; j > 0; j--) {
            right[j - 1] = right[j] * nums[j - 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i + 1];
        }

        return res;
    }
}  

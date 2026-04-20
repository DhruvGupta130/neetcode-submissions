class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;

        for (int right = 0; right < n; right++) {

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }

            dq.offerLast(right);

            if (dq.peekFirst() <= right - k) {
                dq.pollFirst();
            }


            if (right >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }

        }
        return res;
        
    }
}

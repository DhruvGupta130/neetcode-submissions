class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int idx = 0;
        for (int right = 0; right < n; right++) {
            pq.offer(new int[]{nums[right], right});

            while (right - pq.peek()[1] >= k) {
                pq.poll();
            }

            if (right >= k - 1) {
                res[idx++] = pq.peek()[0];
            }

        }
        return res;
        
    }
}

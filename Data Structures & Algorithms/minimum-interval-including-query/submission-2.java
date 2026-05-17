class Solution {
    private record Pair(int size, int end) {}
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] q = new int[n][2];

        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] res = new int[n];
        Arrays.fill(res, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.size() - b.size());

        int i = 0;
        for (int[] query : q) {
            int val = query[0];
            int idx = query[1];

            while (i < intervals.length && intervals[i][0] <= val) {
                int l = intervals[i][0];
                int r = intervals[i][1];

                pq.offer(new Pair(r - l + 1, r));
                i++;
            }

            while (!pq.isEmpty() && pq.peek().end() < val) {
                pq.poll();
            }

            if (!pq.isEmpty())
                res[idx] = pq.peek().size();
        }
        return res;
    }
}

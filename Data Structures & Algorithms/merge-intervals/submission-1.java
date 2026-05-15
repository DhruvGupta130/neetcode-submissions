class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = intervals[i - 1];
            int[] curr = intervals[i];

            if (prev[1] < curr[0]) {
                res.add(prev);
            } else if (prev[0] > curr[1]) {
                res.add(curr);
                intervals[i] = prev;
            } else {
                curr[0] = Math.min(curr[0], prev[0]);
                curr[1] = Math.max(curr[1], prev[1]);
            }
        }
        res.add(intervals[intervals.length - 1]);
        return res.toArray(int[][] ::new);
    }
}
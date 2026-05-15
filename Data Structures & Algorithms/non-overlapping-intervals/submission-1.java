class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int count = 0;

        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (curr[0] < prevEnd) {
                count++;
                prevEnd = Math.min(curr[1], prevEnd);
            } else {
                prevEnd = curr[1];
            }
        }
        return count;
    }
}

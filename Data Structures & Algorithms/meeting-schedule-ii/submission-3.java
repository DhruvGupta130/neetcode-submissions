/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;
        intervals.sort((a, b) -> a.start - b.start);
        int rooms = intervals.size();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);

            if (pq.peek() <= curr.start) {
                pq.poll();
            }
            pq.offer(curr.end);
        }

        return pq.size();
    }
}

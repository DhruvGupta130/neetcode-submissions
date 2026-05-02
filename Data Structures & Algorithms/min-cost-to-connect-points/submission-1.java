class Solution {
    private record Pair(int point, int dist) {}
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist() - b.dist());
        pq.offer(new Pair(0, 0));

        int res = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int point = curr.point();
            int dist = curr.dist();

            if (visited[point])
                continue;

            visited[point] = true;
            res += dist;

            for (int i = 0; i < n; i++) {
                dist = Math.abs(points[i][0] - points[point][0])
                    + Math.abs(points[i][1] - points[point][1]);

                pq.offer(new Pair(i, dist));
            }
        }
        return res;
    }
}

class Solution {
    private record Pair(int v, int d) {}
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.d() - b.d());
        pq.offer(new Pair(0, 0));

        int res = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.v();
            int cost = curr.d();

            if (visited[node])
                continue;
            visited[node] = true;
            res += cost;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(points[node][0] - points[i][0])
                        + Math.abs(points[node][1] - points[i][1]);
                    pq.offer(new Pair(i, dist));
                }
            }
        }
        return res;
    }
}

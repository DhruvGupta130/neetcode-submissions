class Solution {
    private record Pair(int node, int time) {}
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] t : times) {
            int u = t[0], v = t[1], w = t[2];
            graph.get(u).add(new Pair(v, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time() - b.time());
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node();
            int time = curr.time();

            if (time > dist[node])
                continue;

            for (Pair nei : graph.get(node)) {
                int newTime = time + nei.time();

                if (newTime < dist[nei.node()]) {
                    dist[nei.node()] = newTime;
                    pq.offer(new Pair(nei.node(), newTime));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}

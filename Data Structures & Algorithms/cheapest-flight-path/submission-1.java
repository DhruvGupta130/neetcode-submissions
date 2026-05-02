class Solution {
    private record Pair(int node, int cost) {}
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] f : flights) {
            graph.get(f[0]).add(new Pair(f[1], f[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(src, 0));
        dist[src] = 0;

        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int node = curr.node();
                int cost = curr.cost();

                for (Pair nei : graph.get(node)) {
                    int newCost = cost + nei.cost();

                    if (newCost < dist[nei.node()]) {
                        dist[nei.node()] = newCost;
                        q.offer(new Pair(nei.node(), newCost));
                    }
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

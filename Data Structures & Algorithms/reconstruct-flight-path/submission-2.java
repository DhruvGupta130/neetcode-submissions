class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (var t : tickets) {
            graph.computeIfAbsent(t.getFirst(), k -> new PriorityQueue()).offer(t.getLast());
        }
        dfs("JFK", graph, res);
        return res.reversed();
    }

    private void dfs(String node, Map<String, PriorityQueue<String>> graph, List<String> res) {
        PriorityQueue<String> pq = graph.get(node);
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next, graph, res);
        }
        res.add(node);
    }
}

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        String origin = "JFK";
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (var t : tickets) {
            graph.computeIfAbsent(t.getFirst(), k -> new PriorityQueue<>()).offer(t.getLast());
        }

        dfs(origin, graph, res);
        return res.reversed();
    }

    private void dfs(String src, Map<String, PriorityQueue<String>> graph, List<String> res) {
        PriorityQueue<String> pq = graph.get(src);

        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next, graph, res);
        }

        res.add(src);
    }
}

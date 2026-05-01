class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = edges.length;

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            boolean[] visited = new boolean[n + 1];

            if (!graph.get(u).isEmpty() && bfs(u, v, graph, visited)) {
                return e;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0];
    }

    private boolean bfs(int src, int target, List<List<Integer>> graph, boolean[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            Integer curr = q.poll();
            if (curr == target)
                return true;

            for (int nei : graph.get(curr)) {
                if (!visited[nei]) {
                    q.offer(nei);
                    visited[nei] = true;
                }
            }
        }
        return false;
    }
}

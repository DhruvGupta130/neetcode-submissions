class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = edges.length;

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            boolean[] visited = new boolean[n + 1];

            if (!graph.get(u).isEmpty() && dfs(u, v, graph, visited)) {
                return e;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0];
    }

    private boolean dfs(int src, int des, List<List<Integer>> graph, boolean[] visited) {
        if (src == des)
            return true;

        visited[src] = true;

        for (int nei : graph.get(src)) {
            if (!visited[nei]) {
                if (dfs(nei, des, graph, visited))
                    return true;
            }
        }

        return false;
    }
}

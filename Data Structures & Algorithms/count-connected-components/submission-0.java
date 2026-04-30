class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int res = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                res++;
            }
        }
        return res;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        if (visited[node])
            return;

        visited[node] = true;
        for (int nei : graph.get(node)) {
            dfs(nei, graph, visited);
        }
    }
}

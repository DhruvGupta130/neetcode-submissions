class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] p : prerequisites) graph.get(p[1]).add(p[0]);
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state))
                return false;
        }

        return true;
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] state) {
        if (state[node] == 1)
            return false;
        if (state[node] == 2)
            return true;

        state[node] = 1;

        for (int nei : graph.get(node)) {
            if (!dfs(nei, graph, state))
                return false;
        }

        state[node] = 2;
        return true;
    }
}

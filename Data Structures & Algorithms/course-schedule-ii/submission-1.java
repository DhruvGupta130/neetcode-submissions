class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        int[] state = new int[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state, stack)) {
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;

        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }

        return res;
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] state, Stack<Integer> stack) {
        if (state[node] == 1)
            return false;
        if (state[node] == 2)
            return true;

        state[node] = 1;

        for (int nei : graph.get(node)) {
            if (!dfs(nei, graph, state, stack)) {
                return false;
            }
        }

        stack.push(node);
        state[node] = 2;

        return true;
    }
}

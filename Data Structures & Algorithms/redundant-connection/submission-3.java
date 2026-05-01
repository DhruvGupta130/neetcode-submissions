class Solution {
    private int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            if (!union(u, v)) {
                return e;
            }
        }
        return new int[0];
    }

    private boolean union(int src, int des) {
        int ps = find(src);
        int pd = find(des);

        if (ps == pd)
            return false;

        parent[ps] = pd;
        return true;
    }

    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return find(parent[x]);
    }
}

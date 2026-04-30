class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited1 = new boolean[m][n];
                boolean[][] visited2 = new boolean[m][n];
                boolean pacific = dfs(i, j, m, n, heights, visited1, true);
                boolean atlantic = dfs(i, j, m, n, heights, visited2, false);

                if (pacific && atlantic) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private boolean dfs(
        int i, int j, int m, int n, int[][] heights, boolean[][] visited, boolean reached) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j])
            return false;
        if (reached && (i == 0 || j == 0))
            return true;
        if (!reached && (i == m - 1 || j == n - 1))
            return true;

        visited[i][j] = true;

        return (i + 1 < m && heights[i + 1][j] <= heights[i][j]
                   && dfs(i + 1, j, m, n, heights, visited, reached))
            || (i - 1 >= 0 && heights[i - 1][j] <= heights[i][j]
                && dfs(i - 1, j, m, n, heights, visited, reached))
            || (j + 1 < n && heights[i][j + 1] <= heights[i][j]
                && dfs(i, j + 1, m, n, heights, visited, reached))
            || (j - 1 >= 0 && heights[i][j - 1] <= heights[i][j]
                && dfs(i, j - 1, m, n, heights, visited, reached));
    }
}

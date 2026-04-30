class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) dfs(i, 0, heights, pacific);
        for (int j = 0; j < n; j++) dfs(0, j, heights, pacific);

        for (int i = 0; i < m; i++) dfs(i, n - 1, heights, atlantic);
        for (int j = 0; j < n; j++) dfs(m - 1, j, heights, atlantic);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j])
            return;
        visited[i][j] = true;
        int m = heights.length, n = heights[0].length;

        if (i + 1 < m && heights[i + 1][j] >= heights[i][j])
            dfs(i + 1, j, heights, visited);
        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j])
            dfs(i - 1, j, heights, visited);
        if (j + 1 < n && heights[i][j + 1] >= heights[i][j])
            dfs(i, j + 1, heights, visited);
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j])
            dfs(i, j - 1, heights, visited);
    }
}

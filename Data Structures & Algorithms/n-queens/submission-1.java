class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>(), new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int row, int n, Set<Integer> cols, Set<Integer> d1, Set<Integer> d2,
        List<String> curr, List<List<String>> res) {
        if (row == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || d1.contains(col - row) || d2.contains(row + col))
                continue;
            cols.add(col);
            d1.add(col - row);
            d2.add(col + row);

            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[col] = 'Q';
            curr.add(new String(c));

            backtrack(row + 1, n, cols, d1, d2, curr, res);

            cols.remove(col);
            d1.remove(col - row);
            d2.remove(col + row);

            curr.removeLast();
        }
    }
}

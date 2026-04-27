class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, n, new ArrayList<>(), res, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }

    private void backtrack(int row, int n, List<String> board, List<List<String>> res,
        Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col))
                continue;

            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[col] = 'Q';
            board.add(new String(arr));

            backtrack(row + 1, n, board, res, cols, diag1, diag2);

            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
            board.removeLast();
        }
    }
}

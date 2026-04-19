class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;

                if (!isValidRow(i, j, num, board) ||
                    !isValidColumn(i, j, num, board) ||
                    !isValidGrid(i, j, num, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidRow(int row, int col, char num, char[][] board) {
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColumn(int row, int col, char num, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidGrid(int row, int col, char num, char[][] board) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if ((i != row || j != col) && board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
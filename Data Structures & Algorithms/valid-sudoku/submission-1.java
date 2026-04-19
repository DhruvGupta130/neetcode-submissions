class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (!isValidRow(i, j, board) || !isValidColumn(i, j, board)
                || !isValidBox(i, j, board)) return false;
            }
        }
        return true;
    }

    private boolean isValidRow(int i, int j, char[][] board) {
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j]) return false;
        }
        return true;
    }

    private boolean isValidColumn(int i, int j, char[][] board) {
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == board[i][j]) return false;
        }
        return true;
    }

    private boolean isValidBox(int i, int j, char[][] board) {
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;

        for (int k = row; k < row + 3; k++) {
            for (int l = col; l < col + 3; l++) {
                if (k != i && l != j && board[i][j] == board[k][l]) return false;
            }
        }
        return true;
    }
}

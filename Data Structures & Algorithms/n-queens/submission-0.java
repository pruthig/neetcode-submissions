class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        backtrack(0, board, result);
        return result;
    }

    private void backtrack(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board)
                solution.add(new String(r));
            result.add(solution);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (!isValid(row, col, board))
                continue;

            board[row][col] = 'Q';
            backtrack(row + 1, board, result);
            board[row][col] = '.';
        }
    }

    private boolean isValid(int row, int col, char[][] board) {
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 'Q')
                return false;

            int diff = row - r;

            if (col - diff >= 0 && board[r][col - diff] == 'Q')
                return false;

            if (col + diff < board.length && board[r][col + diff] == 'Q')
                return false;
        }

        return true;
    }
}
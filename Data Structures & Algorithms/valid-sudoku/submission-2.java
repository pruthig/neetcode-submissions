class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i=0;i<9;++i) {
            for(int j=0;j<9;++j) {
                char c = board[i][j];
                if(c == '.')
                    continue;
                int digit = c - '1';
                int boxNum = (i/3)*3 + (j/3);
                if(row[i][digit] || col[j][digit] || box[boxNum][digit])
                    return false;
                row[i][digit] = true;
                col[j][digit] = true;
                box[boxNum][digit] = true;
            }
        }
        return true;

    }
}

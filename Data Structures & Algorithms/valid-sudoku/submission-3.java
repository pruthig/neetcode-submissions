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
                int idx = c - '1';
                int boxNumber = (i/3)*3 + (j/3);
                if(row[i][idx] || col[j][idx] || box[boxNumber][idx])
                    return false;
                row[i][idx] = true;
                col[j][idx] = true;
                box[boxNumber][idx] = true;
            }
        }
        return true;
    }
}

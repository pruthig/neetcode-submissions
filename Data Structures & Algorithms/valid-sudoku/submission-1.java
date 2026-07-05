class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check for row
        boolean[] row = new boolean[9];
        for(int i=0;i<9;++i) {
            Arrays.fill(row, false);
            for(int j=0;j<9;++j) {
                if(board[i][j] == '.')
                    continue;
                int idx = board[i][j] - '1';
                if(row[idx])
                    return false;
                row[idx] = true;
            }
        }
        for(int i=0;i<9;++i) {
            Arrays.fill(row, false);
            for(int j=0;j<9;++j) {
                if(board[j][i] == '.')
                    continue;
                int idx = board[j][i] - '1';
                if(row[idx])
                    return false;
                row[idx] = true;
            }
        }
        // box
        for(int i=0;i<9;i+=3) {
            for(int j=0;j<9;j+=3) {
                Arrays.fill(row, false);
                for(int k=i;k<i+3;++k) {
                    for(int l=j;l<j+3;++l) {
                        if(board[k][l] == '.')
                            continue;
                        int idx = board[k][l] - '1';
                        if(row[idx])
                            return false;
                        row[idx] = true;
                    }
                }
            }
        }
        return true;
    }
}

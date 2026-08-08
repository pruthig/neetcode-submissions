class Solution {
    public boolean helper(char[][] board, boolean[][] b, int i, int j, String word, int idx)    {
        if(i<0 || i>=b.length || j<0 || j>=b[0].length) {
            return false;
        }
        if((word.charAt(idx) != board[i][j]) || b[i][j]) {
            return false;
        }
        if(idx == word.length()-1) {
            if(word.charAt(idx) == board[i][j])
                return true;
            else
                return false;
        }
        b[i][j] = true;
        if( helper(board, b, i, j-1, word, idx+1) || helper(board, b, i-1, j, word, idx+1) ||
        helper(board, b, i, j+1, word, idx+1) || helper(board, b, i+1, j, word, idx+1))
            return true;
        b[i][j] = false;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        for(int i=0;i<r;++i) {
            for(int j=0;j<c;++j) {
                boolean[][] b = new boolean[r][c];
                boolean res = helper(board, b, i, j, word, 0);
                if(res)
                    return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean helper(char[][] board, int i, int j, int idx, String word, boolean[][] flag) {
        if(i<0 || i>=flag.length || j<0 || j>=flag[0].length || flag[i][j] ||
            board[i][j] != word.charAt(idx))
            return false;
        if(idx == word.length()-1)
            return true;
        flag[i][j] = true;
        boolean f1 = helper(board, i, j-1, idx+1, word, flag);
        boolean f2 = helper(board, i-1, j, idx+1, word, flag);
        boolean f3 = helper(board, i, j+1, idx+1, word, flag);
        boolean f4 = helper(board, i+1, j, idx+1, word, flag);
        flag[i][j] = false;

        if(f1 || f2 || f3 || f4)
            return true;
        else
            return false;
        
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;++i) {
            for(int j=0;j<board[0].length;++j) {
                boolean f = helper(board, i, j, 0, word, flag);
                if(f)
                    return true;

            }
        }
        return false;
    }
}

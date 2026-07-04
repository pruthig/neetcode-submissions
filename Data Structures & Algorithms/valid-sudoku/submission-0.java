class Solution {
    public boolean isValidSudoku(char[][] board) {
        // declare 
        boolean[] flag = new boolean[9];
        // go row wise
        for(int i=0; i<9;++i) {
            Arrays.fill(flag, false);
            for(int j=0;j<9;++j) {
                // get index
                char c = board[i][j];
                if(c == '.')
                    continue;
                int index = c - '1';
                if(flag[index] == true)
                    return false;
                flag[index] = true;
            }
        }
        // go column wise
        for(int i=0; i<9;++i) {
            Arrays.fill(flag, false);
            for(int j=0;j<9;++j) {
                // get index
                char c = board[j][i];
                if(c == '.')
                    continue;
                int index = c - '1';
                if(flag[index] == true)
                    return false;
                flag[index] = true;
            }
        }
        // check board
        for(int i=0;i<9; i+=3) {
            for(int j = 0;j<9;j+=3) {
                Arrays.fill(flag, false);
                for(int k=i;k<i+3;++k) {
                    for(int l=j;l<j+3;++l) {
                        char c = board[k][l];
                        if(c == '.')
                            continue;
                        int index = c - '1';
                        if(flag[index] == true)
                            return false;
                        flag[index] = true;
                    }
                }
            }

        }
        return true;

    }
}

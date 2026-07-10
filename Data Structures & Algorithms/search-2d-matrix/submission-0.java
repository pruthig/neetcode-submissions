class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // find the row first;
        int row = matrix.length-1;
        int col = matrix[0].length-1;

        int i=0, j=matrix.length-1;
        int r = -1;
        while(i<=j) {
            int mid = (i+j)/2;
            if(target == matrix[mid][0])
                return true;
            else if(target>matrix[mid][0]) {
                if(target<=matrix[mid][col]) {
                    r = mid; break;
                }
                else
                    i = mid+1;
            }
            else {
                j = mid-1;
            }
        }
        if(r == -1)
            return false;
        i = 0;
        j = matrix[0].length-1;
        while(i<=j) {
            int mid = (i+j)/2;
            if(matrix[r][mid] == target)
                return true;
            else if(matrix[r][mid] < target) 
                i = mid+1;
            else
                j = mid-1;

        }
        return false;
    }
}

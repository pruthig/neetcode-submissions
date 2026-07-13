class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nrows = matrix.length;
        int ncols = matrix[0].length;
        int i=0, j=matrix.length-1;
        int row = -1;
        while(i<=j) {
            int mid = (i+j)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][matrix[0].length-1]) {
                row = mid; break;
            } else if(target > matrix[mid][matrix[0].length-1])
                i=mid+1;
            else
                j=mid-1;
        }
        if(row == -1)
            return false;
        i=0; j=matrix[0].length-1;
        while(i<=j) {
            int mid = (i+j)/2;
            if(matrix[row][mid] == target)
                return true;
            else if(target > matrix[row][mid])
                i = mid+1;
            else
                j = mid-1;
        }
        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int lo =0 , high = (rows * cols) -1;
        
        
        int i = 0 , j =0;
        int current = 0 ;
        while(lo <= high){
            int mid = (lo + high) /2;
            i = mid / cols;
            j = mid % cols;
            
            current = matrix[i][j];
            if(target == current){
                return true;
            }
            
            if( current > target){
                high= mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return false;
    }
}

// 6 - [1 , 2 ] 
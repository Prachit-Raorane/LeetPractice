class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        transpose(matrix);
        
        reflect(matrix);
    }
    
    private void transpose(int[][] matrix){
        
        int n = matrix.length;
        
        for(int i=0;i<n;i++){
            for(int j = i +1;j<n;j++){
                matrixSwap(matrix,i,j,j,i);
            }
        }
    }
    
    private void reflect(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0; j<n/2;j++){
               int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp; 
            }
        }
    }
    
    private void matrixSwap(int[][] matrix,int x1,int y1,int x2,int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
    
}
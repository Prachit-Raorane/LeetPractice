class Solution {
    
    int [] [] DIRS = {
        {-1,-1},
        {0,-1},
        {-1,0},
        {1,-1},
        {-1,1},
        {1,1},
        {0,1},
        {1,0}
                     };
    
    
    public void gameOfLife(int[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        playGame(rows,cols,board);
        updateBoard(rows,cols,board);
    }
    
    // 00
    // 01
    // 10
    // 11
    private void playGame(int rows,int cols,int[][] board){
        for(int i=0;i<rows;i++){
            
            for(int j=0;j<cols;j++){
            
                int aliveNeighbours = countAliveNeighbours(i,j,rows,cols,board);
                if(board[i][j] == 0 && aliveNeighbours == 3){
                    board[i][j] = 2;
                }else if(board[i][j] == 1 && (aliveNeighbours == 2 || aliveNeighbours == 3)){   
                    board[i][j] = 3;
                }
            }
        }
        }
    
    private int countAliveNeighbours(int curR,int curC,int rows,int cols,int [] [] board){
        int alive = 0;
        for(int i=0;i<DIRS.length;i++){
            
                int neighbourX = curR + DIRS[i][0];
                int neighbourY = curC + DIRS[i][1];           
                
            if(withinBoundries(neighbourX,neighbourY,rows,cols)){
                alive += board[neighbourX][neighbourY] & 1;
            }
                
        }
        
        return alive;
    }
    
    
    private boolean withinBoundries(int curR,int curC,int rows,int cols){
        return curR>=0 && curR < rows && curC >=0 && curC < cols;
    }
    
    private void updateBoard(int rows,int cols,int [][] board){
        for(int i=0;i<rows;i++){
            
            for(int j=0;j<cols;j++){
                
                board[i][j] >>=  1;
            }
        }
    }
    
}
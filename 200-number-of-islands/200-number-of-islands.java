class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        
        for(int i = 0 ; i< rows ;i++){
            for(int j=0; j < cols;j++){
                
                if(grid[i][j] == '1'){
                    ans ++;
                    
                    dfs(i,j,grid,rows,cols);
                }
            }
        }
        
        return ans;
        
    }
    
    public void dfs(int i,int j,char[][] grid,int row,int col){
        
        grid[i][j] = '0';
        
        if(valid(i,j-1,grid,row,col)){
            dfs(i,j-1,grid,row,col);
        }
        
         if(valid(i,j+1,grid,row,col)){
            dfs(i,j+1,grid,row,col);
        }
        
         if(valid(i-1,j,grid,row,col)){
            dfs(i-1,j,grid,row,col);
        }
        
         if(valid(i+1,j,grid,row,col)){
            dfs(i+1,j,grid,row,col);
        }
    }
    
    public boolean valid(int i,int j,char[][] grid,int row,int col ){
        
        return i>=0 && i< row && j>=0 && j< col && grid[i][j] == '1';
    }
}
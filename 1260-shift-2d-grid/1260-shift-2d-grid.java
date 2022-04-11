class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0 ; i< row;i ++){
            answer.add(new ArrayList());
        }
        
         k = k%(row*col);
        
        int dimension = row * col;
        int begin = dimension - k;
        
         int x = 0;// counter variable
        for (int i = begin; i < begin + dimension; i++) {
            int r = (i / col) % row, c = i % col;// calculating row and cell for new grid
            answer.get(x / col).add(grid[r][c]);// adding new element in new row
            x++;
        }
        
        return answer;
        
    }
}
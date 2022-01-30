class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> cubeSet = new HashSet<>();
            for(int j=0;j<board.length;j++) {
                if(board[i][j]!='.' && !rowSet.add(board[i][j])) {
                    return false;
                } else if(board[j][i]!='.' && !colSet.add(board[j][i])) {
                    return false;
                } else {
                    int r = (3 * (i/3)) + (j/3);
                    int c = (3 * (i%3)) + (j%3);
                    if(board[r][c]!='.' && !cubeSet.add(board[r][c])) {
                        return false;                        
                    }
                }
            }
        }
        return true;
    }
}
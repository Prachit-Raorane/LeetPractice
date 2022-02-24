class Solution {
    int[][] memo;
    private int dp(int row, int column) {
        if (row + column == 0)
            return 1;
        if (memo[row][column] == 0) {
            int ways = 0;
            if (row > 0) {
                ways += dp(row - 1, column);
            }
            if (column > 0) {
                ways += dp(row, column - 1);
            }
            memo[row][column] = ways;
        }
        return memo[row][column];
    }

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return dp(m - 1, n - 1);
    }
}
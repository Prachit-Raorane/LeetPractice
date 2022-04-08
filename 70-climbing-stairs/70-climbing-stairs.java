class Solution {
    
    Map<Integer,Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        
        if(n==0) return 1;
        if(n == 1) return 1;
        
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int dp1 = climbStairs(n-1);
        int dp2 = climbStairs(n-2);
        
        memo.put(n,dp1+dp2);
        return dp1 + dp2;
    }
    
}
class Solution {
    public int maxSubArray(int[] nums) {
        
        int max=Integer.MIN_VALUE;
        int temp=0;
        for(int num:nums){
            temp = temp + num;
            
            max = Math.max(temp,max);
            temp = temp< 0 ? 0 : temp;
        }
        
        return max;
    }
}
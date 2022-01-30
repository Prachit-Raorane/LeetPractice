class Solution {
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        
        if(k == 0){
            k += nums.length;
        }
        
        
        reverse(0,nums.length-k-1,nums);
        reverse(nums.length-k,nums.length-1,nums);
        reverse(0,nums.length-1,nums);
    }
    
    public void reverse(int left,int right,int [] nums){
        while(left< right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            
            left++;
            right --;
        }
    } 
}
class Solution {
    public int majorityElement(int[] nums) {
        
        int pm = nums[0];
        int count = 1;
        
        for(int i =1;i<nums.length;i++){
            
            if(nums[i] == pm){
                count ++;
            }else{
                count --;
            }
            
            if(count == 0){
                pm = nums[i];
                count = 1;
            }
        }
        
        return pm;
       
        
    }
    
    
    private int countInstances(int [] nums, int k){
        
        return Arrays.stream(nums).boxed().filter(n -> n==k).collect(Collectors.counting()).intValue();
    }
}
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
       return atMostKDistinct(nums,k) - atMostKDistinct(nums,k-1);
    }
    
    
    private int atMostKDistinct(int [] nums,int k){
        int left =0;
        
        Map<Integer,Integer> freq = new HashMap<>();
        int count =0;
        for (int i=0;i < nums.length;i++){
            
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            
            while(freq.size()>k){
                freq.put(nums[left],freq.get(nums[left]) - 1);
                if(freq.get(nums[left]) == 0){
                    freq.remove(nums[left]);
                }
                left ++;
            }
            
            count += (i-left+1);
            
        }
      
        return count;
    }
}
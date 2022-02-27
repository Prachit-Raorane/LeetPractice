class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        int idx1,idx2,idx3;
        
        for(idx1=0;idx1+2<nums.length;idx1++){
            
            if(idx1>0 && nums[idx1] == nums[idx1-1]){
                continue;
            }
            
            idx2= idx1 +1;
            idx3 = nums.length -1;
        
            while(idx2<idx3){
                int sum = nums[idx1]+nums[idx2]+nums[idx3];
                
                if(sum == 0){
                    result.add(Arrays.asList(nums[idx1],nums[idx2],nums[idx3]));
                    idx3--;
                    
                    while(idx3> idx2 && nums[idx3] == nums[idx3+1]){
                        idx3--;
                    }
                }else if(sum < 0){
                    idx2 ++;
                }else{
                    idx3 --;
                }
            }
            
        }
        
        return result;
    }
}
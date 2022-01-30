class Solution {
    public int[] twoSum(int[] nums, int target) {
     
        Map<Integer,Integer> numbers = new HashMap<>();
        for(int i =0; i<nums.length; i++){
                numbers.put(nums[i],i);
            }
        
        for(int i=0;i<nums.length;i++){
            int remainder = target - nums[i] ;
            if( numbers.containsKey(remainder) && numbers.get(remainder) != i){
                return new int[]{i,numbers.get(remainder)};
            }
        }
        
        return new int[0];
    }
}
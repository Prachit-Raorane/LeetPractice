class Solution {
        
     public  static int rob(int[] nums) {
        return rob(nums,0,new HashMap<>());
    }


    public static int rob(int[] nums, int index , Map<Integer,Integer> memo) {
          if(index >= nums.length) return 0;
          if(!memo.containsKey(index)) memo.put(index, Math.max(nums[index] + rob(nums,index+2,memo),rob(nums,index+1,memo)));
          return memo.get(index);
    }
}
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int ans=0,sum=0;
        final Map<Integer,Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
            int mod = sum % k;
            
            if(mod < 0) mod += k;
            
            ans += prefix.getOrDefault(mod,0);
            
            prefix.put(mod,prefix.getOrDefault(mod,0)+1);
        }
        
        return ans;
    }
}
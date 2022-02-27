class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        int longest = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                
                int current = num;
                int currentStreak = 1;
                
                while(set.contains(current+1)){
                    currentStreak ++;
                    current ++;
                }
                
                longest = Math.max(currentStreak,longest);
            }
        }
        
        return longest;
    }
}
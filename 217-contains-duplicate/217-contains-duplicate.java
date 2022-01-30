class Solution {
    public boolean containsDuplicate(int[] nums) {
        
       Set<Integer> distinctNumbers =Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        return distinctNumbers.size() != nums.length;
    }
}
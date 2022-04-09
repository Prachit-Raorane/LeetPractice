class Solution {
    
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        backtrack(nums, new ArrayList<>(), 0);
        
        return output;
    }
    
    
    private void backtrack(int[] numbers,List<Integer> set, int index){
        
        if(index == numbers.length){
            output.add(new ArrayList<>(set));
            return;
        }
            
            set.add(numbers[index]);
            backtrack(numbers,set,index+1);
            set.remove(set.size()-1);
            backtrack(numbers,set,index+1);
        
    }
}
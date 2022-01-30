class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
       int n = nums.length;
        for (int k = 0; k < n + 1; ++k) {
            backtrack(nums, new ArrayList<>(), 0,k);
        }
        
        return output.stream().map(list -> {list.sort(Comparator.naturalOrder()); return list;}).distinct().collect(Collectors.toList());
    }
    
    
    private void backtrack(int[] numbers,List<Integer> set, int index, int currentSize){
        
        if(set.size() == currentSize){
            output.add(new ArrayList<>(set));
            return;
        }
        
        for(int i= index;i<numbers.length;i++){
            
            set.add(numbers[i]);
            backtrack(numbers,set,i+1,currentSize);
            set.remove(set.size()-1);
        }
    }
}
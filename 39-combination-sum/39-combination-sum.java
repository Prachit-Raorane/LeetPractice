class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,candidates,new ArrayList<>(),ans,target);
        return ans;
    }
    
    private void findCombinations(int index, int [] candidates,List<Integer> current,List<List<Integer>> ans,int target){
        
        if(index == candidates.length){
            if(target == 0){
            ans.add(new ArrayList<>(current));
            }
            return;
        }
        
        if(candidates[index] <= target){
            current.add(candidates[index]);
            findCombinations(index,candidates,current,ans,target- candidates[index]);
            current.remove(current.size()-1);
        }
            findCombinations(index+1,candidates,current,ans,target);
        
    }
}
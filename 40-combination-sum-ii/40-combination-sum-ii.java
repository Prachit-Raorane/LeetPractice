class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,new ArrayList<>(),ans,target);
        return ans;
    }
    
    private void findCombinations(int index, int [] candidates,List<Integer> current,List<List<Integer>> answer,int target){
        
        if(target == 0){
            answer.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = index;i< candidates.length ; i++){
            
            if(i> index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            
            if(target - candidates[i] < 0) break;
            
            current.add(candidates[i]);
            findCombinations(i+1,candidates,current,answer,target-candidates[i]);
            current.remove(current.size()-1);
        }
    }
    
}

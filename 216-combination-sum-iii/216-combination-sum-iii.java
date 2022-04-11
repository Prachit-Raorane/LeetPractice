class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> l = new ArrayList<>();
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};   
        combinationSum3(l, new ArrayList<Integer>(), numbers, k, n, 0);
        return l;
    }
    
    private void combinationSum3(List<List<Integer>> l, 
                                 ArrayList<Integer> al, int[] numbers,int k, int n, int index){   
        
        //BASE CASES
        if(k < 0 || n < 0) return;
        if(index >= numbers.length){
            if(k == 0 && n == 0) {
                l.add(new ArrayList<>(al));
            }
            return;
        }
        
        al.add(numbers[index]);
        combinationSum3(l, al, numbers, k - 1, n - numbers[index], index + 1);
        al.remove(al.size() - 1);
        
        combinationSum3(l, al, numbers, k, n, index + 1);
        
    }   
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList();
        
        List<Integer> currentRow,previousRow = null;
        
        for(int i = 0 ; i < numRows ; i++ ){
            
            currentRow = new ArrayList<>();
            for(int j=0; j <= i ; j++){
                
                if(j==0 || j==i){
                    currentRow.add(1);
                }else{
                    currentRow.add(previousRow.get(j-1)+previousRow.get(j));
                }
                
            }
            
            result.add(currentRow);
            previousRow = currentRow;
        }
        
        return result;
    }
}
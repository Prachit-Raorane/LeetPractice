class Solution {
        final String [] keyboard = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        if(digits == null || digits.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> result = new ArrayList<>();
        
        //initial String
        result.add("");
        
        for(char currentChar : digits.toCharArray()){
            
            String currentText = keyboard[currentChar -'2'];
            List<String> newResult = new ArrayList<>();
            
            for(String item : result ){
                
            for(char currentDigit: currentText.toCharArray()){
                
                    newResult.add(item+currentDigit);
                }
            }
            
            result = newResult;
            
        }
    
        
        return result;
    }
}
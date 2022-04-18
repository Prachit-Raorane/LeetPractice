class Solution {
    Map<Character,Character> pairs = new HashMap<>();
    
    public boolean isValid(String s) {
        pairs.put(')','(');
        pairs.put('}','{');
        pairs.put(']','[');
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
        
            if(pairs.containsKey(c)){
                if(stack.isEmpty() || (!stack.pop().equals(pairs.get(c)))){
                    return false;
                }
            }else{
                stack.push(c);
            }
            
        }
        
        return stack.isEmpty();
    }
}
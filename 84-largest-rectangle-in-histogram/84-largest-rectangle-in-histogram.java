class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int maxAnswer = 0;
        
        int [] ps = findPreviousSmaller(heights);
        
        int [] ns = findNextSmaller(heights);
        
        for(int i =0; i < heights.length ; i++){
            int cur = (ns[i] - ps[i] - 1) * heights[i];
            maxAnswer = Math.max(cur,maxAnswer);
        }
        
        return maxAnswer;
    }
    
    private int[] findPreviousSmaller(int [] heights){
        
        int [] result = new int[heights.length];
        
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i < heights.length ; i++ ){
            
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            
            if(s.isEmpty()){
                result[i] = -1;
            }else{
                result[i] = s.peek();
            }
            
            s.push(i);
        }
        
        return result;
    }
    
    
    
    private int[] findNextSmaller(int [] heights){
        
        int [] result = new int[heights.length];
        
        Stack<Integer> s = new Stack<>();
        
        for(int i=heights.length - 1; i >= 0 ; i-- ){
            
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            
            if(s.isEmpty()){
                result[i] = heights.length;
            }else{
                result[i] = s.peek();
            }
            
            s.push(i);
        }
        
        return result;
    }
}
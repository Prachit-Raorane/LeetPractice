class Solution {
    public String longestPalindrome(String s) {
        
        int start =0 , end =0 ;
        int length;
        
        for(int i=0;i<s.length();i++){
            
            int evenSubString = expandAtCenter(s,i,i+1);
            int oddSubString = expandAtCenter(s,i,i);
            
            length = Math.max(evenSubString,oddSubString);
            if(length>end-start+1)
            {
               
                start = i-(length-1)/2;
                end=i+length/2;
            }
        }
        
        return s.substring(start,end+1);
        
    }
    
    public int expandAtCenter(String s, int left,int right){
        
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            
            left--;
            right++;
        }
        
        return right - left - 1 ;
        
    }
}
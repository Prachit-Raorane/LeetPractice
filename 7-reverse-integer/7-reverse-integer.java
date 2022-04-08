class Solution {
    public int reverse(int x) {
        
        int signMultiplier = 1;
        
        if(x < 0){
            signMultiplier = -1;
            x = x * signMultiplier;
        }
        int result = 0;
        
        while(x > 0){
    if (result * signMultiplier > Integer.MAX_VALUE / 10 || result * signMultiplier < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = (result *10) + x%10;
            x /= 10; 
        }
        
        
        return result * signMultiplier;
    }
}
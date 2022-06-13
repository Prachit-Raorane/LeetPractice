class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq=new int[3];
        int left=0,right=0,count=0,length=s.length(),unique=0;
        while(right<length) {
            int idx=s.charAt(right)-97;
            if(freq[idx]==0)
                ++unique;
            ++freq[idx];
            if(unique==3) {
                while(left<length&&unique==3) {
                    int leftIdx=s.charAt(left)-97;
                    if(freq[leftIdx]==1)
                        unique--;
                    freq[leftIdx]--;
                    ++left;
                    count+=(length-right);
                }
            }
            ++right;
            
        }
        return count;
        
    }
}
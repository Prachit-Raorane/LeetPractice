class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,res=0,count=0;
        int n=nums.length;
        while(r<n)
        {
            while(r<n)
            {
                if(nums[r]==0 &&k==0)
                    break;
                else if(nums[r]==0)
                    k--;
                count++;
                r++;
            }
            res=Math.max(res,count);
            
            if(r!=n)
            {
                count--;
                if(nums[l]==0)
                    k++;
                l++;
            }
        }
        return res;
    }
}
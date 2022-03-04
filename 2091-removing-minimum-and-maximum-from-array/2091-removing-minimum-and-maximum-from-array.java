class Solution {
     public int minimumDeletions(int[] nums) {
        if(nums.length==1)
            return 1;
        int min=Integer.MAX_VALUE,minplace=0,max=Integer.MIN_VALUE,maxplace=0;
        //Find positions
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                maxplace=i;
            }
            if(nums[i]<min)
            {
                min=nums[i];
                minplace=i;
            }
        }
		/*We are checking for minimum of the 3 conditions
		1. Either side of the array: Math.min(minplace,maxplace)+1+nums.length-Math.max(minplace,maxplace)
		2. First half of the array: Math.max(minplace,maxplace)+1
		3. Second half of the array: nums.length-Math.min(minplace,maxplace)*/
        return Math.min(Math.min((Math.min(minplace,maxplace)+1+nums.length-Math.max(minplace,maxplace)),Math.max(minplace,maxplace)+1),nums.length-Math.min(minplace,maxplace)); 
        
    }
}
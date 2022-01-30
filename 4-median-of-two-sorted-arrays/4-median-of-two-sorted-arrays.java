class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int num1P = 0 , num2P = 0, merP=0;
        
        int max = ((nums1.length + nums2.length) /2 ) + 1; 
        
        int[] merged = new int[max];
        
        boolean isEvenTotal = (nums1.length + nums2.length) % 2 == 0;
        
        while(num1P < nums1.length && num2P < nums2.length && merP < max){
            
            if(nums1[num1P] <= nums2[num2P]){
                merged[merP] = nums1[num1P];
                num1P ++;
            }else{
                merged[merP] = nums2[num2P];
                num2P ++;
            }
            
            merP ++;
        }
        
        while(num1P < nums1.length &&  merP < max){
            merged[merP] = nums1[num1P];
            num1P ++;
            merP ++;
        }
        
        
        while(num2P < nums2.length &&  merP < max){
            merged[merP] = nums2[num2P];
            num2P ++;
            merP ++;
        }
        
        if(isEvenTotal){
            double total =  (merged[max-1] + merged[max -2 ]);
            return total/2;
        }else{
            return merged[max-1];
        }
    }
}
class Solution {
   
     
        public void merge(int[] nums1, int m, int[] nums2, int n) {
     
        
        Queue<Integer> queue = new PriorityQueue<>();
        
         queue.
                        addAll(Arrays.stream(nums1).limit(m).boxed().collect(Collectors.toList()));
        queue.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        
        int i=0;
        while(!queue.isEmpty()){
            nums1[i] = queue.poll();
            i++;
        }
        
    }
    
}
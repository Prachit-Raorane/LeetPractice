class Solution {
    public int lastStoneWeight(int[] stones) {
        
        Queue<Integer> ordered = new PriorityQueue<>(Comparator.reverseOrder());
        
        Arrays.stream(stones).forEach(s-> ordered.offer(s));
        
        while(ordered.size()>1){
            int first = ordered.poll();
            int second = ordered.poll();
                if(first != second){
                    ordered.offer(first- second);
                }
            }
        
         return ordered.isEmpty() ? 0 : ordered.poll();
    
        }
        
       
}
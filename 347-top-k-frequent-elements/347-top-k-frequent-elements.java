class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int [] result = new int[k];
        Map<Integer,Long> frequency = Arrays.stream(nums)
                                            .boxed()
                                            .collect(Collectors.groupingBy
                                                    ( Function.identity(),
                                                     Collectors.counting()
                                                    ));
        
        Queue<Integer> queue = new PriorityQueue((a,b) -> (int) (frequency.get(b) -                        frequency.get(a)));
        
        queue.addAll(frequency.keySet());
        
        int index = 0;
        while(!queue.isEmpty() && index < k ){
            result[index] = queue.poll();
            index ++;
        }
        
        return result;
        
    }
}
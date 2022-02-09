class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //maintain a min heap with fixed k size
        for(int value: nums){
            queue.offer(value);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}

/**
3
2 3
1 2 3
1 2 5
1 2 6
1 2 4
**/
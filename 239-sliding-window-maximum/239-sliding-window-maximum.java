class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // Monotonically decreasing [3, -1]. Store indices
    int[] res = new int[nums.length - k + 1];
    int rIdx = 0;
    for (int j = 0; j < nums.length; j++) {
      while (!deque.isEmpty() && nums[deque.getLast()] < nums[j]) deque.removeLast(); // Maintain monotonically-decreasing property
      if (!deque.isEmpty() && deque.getFirst() <= j - k) deque.removeFirst(); // Left values fall out the window
      deque.addLast(j);
      if (j >= k - 1) res[rIdx++] = nums[deque.getFirst()]; // Largest values at front
    }
    return res;
  }
    
}
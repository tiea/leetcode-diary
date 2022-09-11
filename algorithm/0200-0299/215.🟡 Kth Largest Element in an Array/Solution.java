import java.util.Queue;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Queue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int i = 0; i < len; i++) {
            int size = queue.size();
            int cur = nums[i];
            if (size < k) {
                queue.offer(cur);
            } else {
                int min = queue.peek();
                if (min < cur) {
                    queue.poll();
                    queue.offer(cur);
                }
            }
        }
        return queue.peek();
    }

}
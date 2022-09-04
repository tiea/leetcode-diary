class Solution {

    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, max = 0, curMax = 0, cur = 0;
        boolean changed = false;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            cur = nums[i];
            if (cur == 1) {
                if (!changed) {
                    left++;
                } else {
                    right++;
                }
                continue;
            }
            if (cur == 0) {
                if (!changed) {
                    changed = true;
                    continue;
                }
                curMax = left + right;
                max = max > curMax ? max : curMax;
                left = right;
                right = 0;
            }
        }
        if (!changed) {
            return length - 1;
        }
        curMax = left + right;
        return max > curMax ? max : curMax;
    }

}
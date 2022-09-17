class Solution {

    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int sum = 0, pos = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum >= x) {
                pos = i;
                if (sum == x) {
                    ans = len - i;
                }
                break;
            }
        }
        int i = 0, count = 0;
        while (i < len && pos <= len && count <= len) {
            count = len - pos + i;
            if (sum > x && pos < len) {
                sum -= nums[pos];
                pos++;
            } else if (sum == x) {
                if (count <= len) {
                    ans = Math.min(ans, len - pos + i);
                }
                sum += nums[i];
                i++;
            } else {
                sum += nums[i];
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
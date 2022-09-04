import java.util.Arrays;

class Solution {

    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = original;
        for (int i = 0; i < len; i++) {
            if (nums[i] == ans) {
                ans = nums[i] * 2;
            }
        }
        return ans;
    }

}
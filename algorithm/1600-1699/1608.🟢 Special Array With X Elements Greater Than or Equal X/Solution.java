import java.util.Arrays;

class Solution {

    public int specialArray(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int pos = len - i;
            if (nums[i] >= pos && (i == 0 || nums[i - 1] < pos)) {
                return pos;
            }
        }
        return -1;
    }

}
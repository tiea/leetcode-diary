import java.util.Arrays;

class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        int avg = sum / k;
        Arrays.sort(nums);
        int r = 0, l = len - 1;
        int subSum = 0;
        while (r <= l) {
            int lNum = nums[l];
            int rNum = nums[r];
            if (lNum > avg) {
                return false;
            }
            if (lNum == avg) {
                l--;
                continue;
            }
            subSum = lNum + rNum;
            if (subSum == avg) {
                l--;
                r++;
                continue;
            }
            if (subSum < svg) {

            }
        }
        return true;
    }

}
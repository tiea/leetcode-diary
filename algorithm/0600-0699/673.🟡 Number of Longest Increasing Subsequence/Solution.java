import java.util.Arrays;

class Solution {


    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        int count = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (nums[i] >= nums[j]) {
                    if (dp[i] == max) {
                        count++;
                    } else if (dp[i] > max) {
                        max = dp[i];
                        count = 1;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        new Solution().findNumberOfLIS(new int[] {2,2,2,2,2});
    }

}
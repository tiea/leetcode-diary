class Solution {

    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int[] count = new int[len + 1];
        for (int i = 0; i < len; i++) {
            count[nums[i]]++;
        }
        int[] ans = new int[2];
        for (int i = 1; i < len + 1; i++) {
            int c = count[i];
            if (c == 0) {
                ans[1] = i;
            } else if (c == 2) {
                ans[0] = i;
            }
        }
        return ans;
    }

}
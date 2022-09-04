class Solution {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int f = 0, s = 0;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            if (f <= cur) {
                s = f;
                f = cur;
            }
            if (cur > s && f < cur) {
                s = cur;
            }
        }
        return (f - 1) * (s - 1);
    }

}
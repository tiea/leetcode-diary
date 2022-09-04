class Solution {

    public boolean isIdealPermutation(int[] nums) {
        int len = nums.length;
        int min = nums[len - 1];
        for (int i = len - 1; i >= 2; i--) {
            min = Math.min(nums[i], min);
            if (nums[i - 2] > min) {
                return false;
            }
        }
        return true;
    }


    public boolean isIdealPermutationTimeout(int[] nums) {
        int len = nums.length;
        if (len == 1 || len == 2) {
            return true;
        }
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 2; j < len; j++) {
                if (nums[i] > nums[j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
class Solution {

    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;            
        }
        int split = 0;
        int pre = nums[0];
        for (int i = 0; i < length; i++) {
            int cur = nums[i];
            if (i != 0 && cur >= 0 && pre < 0) {
                split = i;
            } else if (i == length - 1 && pre < 0) {
                split = i;
            }
            pre = nums[i];
            nums[i] = nums[i] * nums[i];
        }
        int[] res = new int[length];
        int l = split - 1;
        int r = split;
        if (split == 0) {
            l = split;
            r = split + 1;
        } else if (split == length - 1) {
            l = split - 1;
        }
        int i = 0;
        int rNum = 0, lNum = 0;
        while (i < length) {
            if (l < 0) {
                res[i++] = nums[r];
                r++;
                continue;
            }
            if (r >= length) {
                res[i++] = nums[l];
                l--;
                continue;
            }
            rNum = nums[r];
            lNum = nums[l];
            if (rNum > lNum) {
                res[i++] = lNum;
                l--;
            } else if (rNum < lNum) {
                res[i++] = rNum;
                r++;
            } else {
                res[i++] = lNum;
                res[i++] = rNum;
                l--;
                r++;
            }
        }
        return res;
    }
}
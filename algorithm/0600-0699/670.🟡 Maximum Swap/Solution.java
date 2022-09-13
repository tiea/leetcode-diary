import java.util.Arrays;

class Solution {

    public int maximumSwap(int num) {
        int[] nums = new int[9];
        int len = 0, cur = num;
        while (cur > 0) {
            nums[len++] = cur % 10;
            cur = cur / 10;
        }
        int[] sortNum = Arrays.copyOf(nums, len);
        Arrays.sort(sortNum);
        int sourceNum = 0, sourcePos = 0;
        int targetPos = 0;
        for (int i = len - 1; i > 0; i--) {
            if (sortNum[i] != nums[i]) {
                sourceNum = sortNum[i];
                break;
            }
        }
        if (sourceNum == 0) {
            return num;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == sourceNum) {
                sourcePos = i;
                break;
            }
        }
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] < sourceNum) {
                targetPos = i;
                break;
            }
        }
        nums[sourcePos] = nums[targetPos];
        nums[targetPos] = sourceNum;
        int ans = 0;
        cur = 1;
        for (int i = 0; i < len; i++) {
            ans += (cur * nums[i]);
            cur *= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().maximumSwap(98004365);
    }

}
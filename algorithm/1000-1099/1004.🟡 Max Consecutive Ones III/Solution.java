import java.util.List;
import java.util.ArrayList;

class Solution {

    public int longestOnes(int[] nums, int k) {
        int length = nums.length;
        List<Integer> preList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                if (count > 0) {
                    preList.add(count);
                }
                preList.add(0);
                count = 0;
            } else {
                count++;
            }
        }
        if (count > 0) {
            preList.add(count);
        }
        int max = 0, remain = k;
        count = 0;
        length = preList.size();
        int start = 0;
        int cur = 0;
        for (int i = 0; i < length; i++) {
            cur = preList.get(i);
            if (remain == 0) {
                if (cur > 0) {
                    count += cur;
                }
                if (count > max) {
                    max = count;
                }
                if (cur == 0) {
                    int startCount = preList.get(start++);
                    if (startCount != 0) {
                        count -= startCount;
                        start++;
                    }
                }
            } else {
                if (cur > 0) {
                    count += cur;
                } else if (cur == 0) {
                    count++;
                    remain--;
                }
            }
        }
        if (count > max) {
            return count;
        }
        return max;
    }

    public static void main(String[] args) {
        new Solution().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
    }

}


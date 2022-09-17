import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            int lPos = i, rPos = len - 1;
            int l = nums[lPos], r = nums[rPos];
            while(lPos < rPos - 1 && l + 2 * r >= 0) {
                l = nums[lPos];
                r = nums[rPos];
                int sum = l + r;
                if (sum > r) {
                    break;
                }
                if (sum < l) {
                    break;
                }
                int other = Arrays.binarySearch(nums, lPos + 1, rPos, 0 - sum);
                if (other > 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(l);
                    list.add(nums[other]);
                    list.add(r);
                    ans.add(list);
                }
                while (lPos < rPos - 1 && r == nums[rPos]) {
                    rPos--;
                }
            }
            while (l == nums[i + 1] && i < len - 2) {
                i++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        new Solution().threeSum(new int[]{-1,0,1,2,-1,-4});
    }

}
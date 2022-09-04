import java.util.Arrays;

class Solution {

    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (l, r) -> l[1] - r[1]);
        int ans = 1;
        int cur = pairs[0][1];
        for (int i = 1; i < len; i++) {
            if (cur < pairs[i][0]) {
                cur = pairs[i][1];
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        new Solution().findLongestChain(new int[][]{{9,10},{-4,9},{-5,6},{-5,9},{8,9}});
    }

}
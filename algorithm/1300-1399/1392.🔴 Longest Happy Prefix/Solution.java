class Solution {

    public String longestPrefix(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int[] ans = new int[len];
        int l = 0, r = 1;
        while (r < len) {
            if (c[l] == c[r]) {
                ans[r] = l + 1;
                l++;
                r++;
                continue;
            }
            if (c[l] != c[r]) {
                if (l == 0) {
                    r++;
                    continue;
                }
                l = ans[l - 1];
            }
        }
        return s.substring(0, ans[len - 1] + 1);
    }

    public static void main(String[] args) {
        new Solution().longestPrefix("acccbaaacccbaac");
    }
    
}
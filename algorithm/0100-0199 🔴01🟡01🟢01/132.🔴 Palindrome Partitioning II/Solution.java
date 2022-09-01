class Solution {

    public int minCut(String s) {
        int len = s.length();
        if (len == 1) {
            return 0;
        }
        char[] c = s.toCharArray();
        if (len == 2) {
            return isPalindrome(c, 0, 1) ? 0 : 1;
        }
        int[] stepCount = new int[len];
        for (int i = 0; i < len; i++) {
            boolean palindrome = false;
            for (int j = len - 1; j > i; j--) {
                palindrome = isPalindrome(c, i, j);
                if (palindrome) {
                    stepCount[i] = j - i + 1;
                    break;
                }
            }
            if (!palindrome) {
                stepCount[i] = 1;
            }
        }
        int ans = minCut(stepCount, 0, 0);
        return ans;
    }
    
    public int minCut(int[] c, int pos, int block) {
        if (pos == c.length - 1) {
            return block;
        }
        if (pos == c.length) {
            return block - 1;
        }
        int step = c[pos];
        if (step == 1) {
            return minCut(c, pos + 1, block + 1);
        }
        if (isDecrease(c, pos, step)) {
            return minCut(c, pos + step, block + 1);
        }
        int min = c.length;
        for (int i = 1; i <= step; i++) {
            int tmp = 0;
            if (i == step) {
                tmp = minCut(c, pos + i, block + 1);
            } else {
                tmp = minCut(c, pos + i, block + i);
            }
            if (tmp < min) {
                min = tmp;
            }
        }
        return min;
    }

    public boolean isDecrease(int[] c, int start, int len) {
        for (int i = 0; i < len - 1; i++) {
            if (c[start + i] < c[start + i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(char[] c, int start, int end) {
        while (start <= end) {
            if (c[start++] != c[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().minCut("adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece");
    }

}
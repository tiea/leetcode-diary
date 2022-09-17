import java.util.Arrays;

class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {

        int[] map = new int[26];
        Arrays.fill(map, -1);
        int len = s.length();
        int ans = -1;
        
        for (int i = 0; i < len; i++) {
            int ch = s.charAt(i) - 'a';
            int pre = map[ch];
            if (pre == -1) {
                map[ch] = i;
            } else {
                ans = Math.max(ans, i - pre - 1);
            }
        }
        return ans;

    }

}
class Solution {

    public int minimumMoves(String s) {
        int ans = 0, length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'O') {
                continue;
            }
            ans++;
            i += 2;
        }
        return ans;
    }

}
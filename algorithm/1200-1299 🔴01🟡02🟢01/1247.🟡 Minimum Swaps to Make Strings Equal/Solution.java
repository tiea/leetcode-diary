class Solution {

    public int minimumSwap(String s1, String s2) {
        int len = s1.length();
        int xyCount = 0;
        int yxCount = 0;
        for (int i = 0; i < len; i++) {
            char cur = s1.charAt(i);
            if (cur != s2.charAt(i)) {
                if (cur == 'x') {
                    xyCount++;
                } else {
                    yxCount++;
                }
            }
        }
        int diff = xyCount + yxCount;
        if (diff % 2 == 1) {
            return -1;
        }
        return diff / 2 + xyCount % 2;
    }
    
}
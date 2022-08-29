class Solution {
    
    public int maxScore(String s) {
        char[] arr = s.toCharArray();
        int length = arr.length;
        int zero = 0, one = 0, cur = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                if (arr[i] == '0') {
                    cur++;
                }
                continue;
            }
            if (i == length - 1) {
                if (arr[length - 1] == '1') {
                    one++;
                }
                break;
            }
            char item = arr[i];
            if (item == '0') {
                zero++;
            } else {
                one++;
            }
            // 获取标记位
            if (zero > one) {
                cur += zero;
                zero = 0;
                one = 0;
            }   
        }
        return cur + one;
    }

    public static void main(String[] args) {
        new Solution().maxScore("01110100111101000000011101011101011101");
    }
}
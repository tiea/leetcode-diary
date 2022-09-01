import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int lowLen = (low + "").length();
        int highLen = (high + "").length();
        for (int i = lowLen; i <= highLen; i++) {
            for (int j = 1; j < 9 - i; j--) {
                String s = "";
                for (int pos = 0; pos < i; pos++) {
                    s += ("" + j);
                }
                int num = Integer.valueOf(s);
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        return ans;
    }
    
}
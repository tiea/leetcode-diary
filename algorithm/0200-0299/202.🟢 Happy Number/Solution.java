import java.util.Set;
import java.util.HashSet;

class Solution {
    
    public boolean isHappy(int n) {
        boolean isHappy = false;
        int num = n;
        Set<Integer> nums = new HashSet<>();
        while (true) {
            int cur = num;
            num = 0;
            while (cur > 0) {
                int mod = cur % 10;
                num += (mod * mod);
                cur = cur / 10;
            }
            if (num == 1) {
                isHappy = true;
                break;
            }
            if (nums.contains(num)) {
                break;
            }
            nums.add(num);
        }
        return isHappy;
    }

}
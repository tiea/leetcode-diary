class Solution {

    public boolean checkPerfectNumber(int num) {
        if (num <= 4) {
            return false;
        }
        int sum = 1, ptr = 2;
        int divisor = num / ptr;
        int end = (num / 4) + 1;
        while (ptr <= end && ptr < divisor) {
            int mod = num % ptr;
            if (mod > 0) {
                divisor = num / ++ptr;
                continue;
            }
            sum += ptr;
            if (divisor != ptr) {
                sum += divisor;
            }
            divisor = num / ++ptr;
        }
        return sum == num;
    }

}
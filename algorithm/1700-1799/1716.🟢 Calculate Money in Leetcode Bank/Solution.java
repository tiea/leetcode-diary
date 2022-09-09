class Solution {

    public int totalMoney(int n) {
        if (n <= 7) {
            return (1 + n) * n / 2;
        }
        int mod = n % 7;
        int week = n / 7;
        return ((week - 1) * week / 2) * 7 + 28 * week + (1 +  2 * week + mod) * mod / 2;
    }

}
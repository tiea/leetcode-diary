class Solution {

    public int preimageSizeFZF(int k) {
        long start = 0L, end = 5L * k, mid;
        while(end >= start) {
            mid = start + (end - start) / 2;
            long n = 5L, nums = 0L;
            while (n <= mid) {
                nums += mid / n;
                n *= 5;
            }
            if (nums == k) {
                return 5;
            } else if (nums < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    public int preimageSizeFZFTimeOut(int k) {
        int zeroCount = 4, ans = 0;
        int i = 25;
        while (true) {
            int cur = i;
            if (k <= zeroCount) {
                ans = 5;
                break;
            }
            do {
                cur = cur / 5;
                zeroCount++;
            } while (cur % 5 == 0);
            if (zeroCount > k) {
                ans = 0;
                break;
            }
            i = i + 25;
            zeroCount = zeroCount + 4;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().preimageSizeFZF(1000000000);
    }


}
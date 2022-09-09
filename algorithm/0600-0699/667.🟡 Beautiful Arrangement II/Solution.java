class Solution {

    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int pos = 0;
        int l = 1, r = n;
        ans[pos++] = l++;
        while (true) {
            if (k <= 1) {
                break;
            }
            ans[pos++] = r--;
            k--;
            if (k <= 1) {
                break;
            }
            ans[pos++] = l++;
            k--;
        }
        int start = ans[pos - 1];
        if (start > n / 2) {
            for (int i = r; pos < n; i--) {
                ans[pos++] = i;
            }
        } else {
            for (int i = l; pos < n; i++) {
                ans[pos++] = i;
            }
        }
        return ans;

    }

}
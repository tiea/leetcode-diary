class Solution {

    int[] memory;

    public int climbStairs(int n) {
        memory = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memory[i] = -1;
        }
        return next(n);
    }

    public int next(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memory[n] != -1) {
            return memory[n];
        }
        memory[n] = next(n - 1) + next(n - 2);
        return memory[n];
    }

}
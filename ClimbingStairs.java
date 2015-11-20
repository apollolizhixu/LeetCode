public class Solution {
    public int climbStairs(int n) {
        //Time: O(n), Space: O(1)
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int steps = 0;
        int prePre = 1;
        int pre = 1;
        for (int i = 2; i <= n; i++) {
            steps = prePre + pre;
            prePre = pre;
            pre = steps;
        }
        return steps;
    }
}
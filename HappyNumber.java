public class Solution {
    //Time: O(n), Space: O(1)
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        int x = n, y = n;
        while (x != 1) {
            x = cal(x);
            if (x == 1) {
                return true;
            }
            y = cal(cal(y));
            if (x == y) {
                return false;
            }
        }
        return true;
    }
    public int cal(int i) {
        int x = i;
        int s = 0;
        while (x > 0) {
            s += (x % 10) * (x % 10);
            x /= 10;
        }
        return s;
    }
}
public class Solution {
    public int rob(int[] nums) {
        //Time: O(n), Space: O(1)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n -1));
    }
    public int helper(int[] nums, int start, int end) {
        int prePre = nums[start];
        int pre = Math.max(nums[start], nums[start + 1]);
        int cur = pre;
        for (int i = start + 2; i <= end; i++) {
            cur = Math.max(pre, prePre + nums[i]);
            prePre = pre;
            pre = cur;
        }
        return cur;
    }
}
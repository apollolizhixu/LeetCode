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
        int prePre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        int max = 0;
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(pre, prePre + nums[i]);
            prePre = pre;
            pre = max;
        }
        return max;
    }
}
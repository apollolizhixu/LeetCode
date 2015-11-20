public class Solution {
    public int majorityElement(int[] nums) {
        //Time: O(n), Space: O(1)
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int rst = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                rst = nums[i];
                count++;
            } else {
                if (rst == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return rst;
    }
}
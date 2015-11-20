public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            sum = null;
        } else {
            sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = nums[i] + sum[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (sum == null) {
            return 0;
        }
        int rst = sum[j];
        if (i > 0) {
            rst -= sum[i - 1];
        }
        return rst;
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(rst, list, nums, 0);
        return rst;
    }
    public void helper(List<List<Integer>> rst, List<Integer> list, int[] nums, int index) {
        rst.add(new ArrayList<Integer>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(rst, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Time: O(n), Space: O(1)
        List<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int rst1 = 0, rst2 = 0, count1 = 0, count2 = 0;
        for (int i : nums) {
            if (rst1 == i) {
                count1++;
            } else if (rst2 == i) {
                count2++;
            } else if (count1 == 0) {
                rst1 = i;
                count1++;
            } else if (count2 == 0) {
                rst2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == rst1) {
                count1++;
            } else if (i == rst2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            rst.add(rst1);
        }
        if (count2 > nums.length / 3) {
            rst.add(rst2);
        }
        return rst;
    }
}
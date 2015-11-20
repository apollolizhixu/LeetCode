public class Solution {
    public int lengthOfLIS(int[] nums) {
    //Time: O(nlogn), Space: O(n);
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        int len = 0;
        for (int i : nums) {
            if (list.isEmpty() || i > list.get(list.size() - 1)) {
                list.add(i);
                len++;
            } else {
                int p = binarySearch(list, 0, len - 1, i);
                list.set(p, i);
            }
        }
        return list.size();
    }
    public int binarySearch(List<Integer> list, int start, int end, int i) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == i) {
                return mid;
            } else if (list.get(mid) > i) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (list.get(start) > i) {
            return start;
        } else {
            return end;
        }
    }
}
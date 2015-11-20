public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Time: O(n), Space: O(n)
        if (nums.length <= 0 || nums == null || k <= 0 || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] rst = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (list.size() > 0 && list.peekLast() - list.peekFirst() >= (k - 1)) {
                list.pollFirst();
            }
            while (list.size() > 0 && nums[list.peekLast()] < nums[i]) {
                list.pollLast();
            }
            list.offerLast(i);
            if (i - k + 1 >= 0) {
                rst[i - k + 1] = nums[list.peekFirst()];
            }
        }
        return rst;
    }

        public int[] maxSlidingWindow1(int[] nums, int k) {
        //Time: O(n), Space: O(n)
        if (nums.length <= 0 || nums == null || k <= 0 || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        int[] rst = new int[n - k + 1];
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        left_max[0] = nums[0];
        right_max[n - 1] = nums[n - 1];
        
        for (int i = 1; i < n; i++) {
            left_max[i] = i % k == 0 ? nums[i] : Math.max(nums[i], left_max[i - 1]);
            
            int j = n - 1 - i;
            right_max[j] = (j + 1) % k == 0 ? nums[j] : Math.max(nums[j], right_max[j + 1]);
        }
        for (int i = 0; i < n - k + 1; i++) {
            rst[i] = Math.max(right_max[i], left_max[i + k - 1]);
        }
        return rst;
    }


    Comparator<Integer> maxHeap = new Comparator<Integer>(){
        public int compare(Integer i1, Integer i2) {
            return i2.compareTo(i1);
        }
    };
    public int[] maxSlidingWindow2(int[] nums, int k) {
        //Time: O(nlogk), Space: O(k)
        if (nums.length <= 0 || nums == null || k <= 0 || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        int[] rst = new int[n - k + 1];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, maxHeap);
        int start = 0;
        for (int i = 0; i < k - 1; i++) {
            q.add(nums[i]);
        }
        for (; start < n - k + 1; start++) {
            if (start != 0) {
                q.remove(nums[start - 1]);
            }
            q.add(nums[start + k - 1]);
            rst[start] = q.peek();
        }
        return rst;
    }
}
public class Solution {
    public int nthUglyNumber(int n) {
        //Time: O(n), Space: O(n)
        if (n <= 0) {
            return 0;
        }
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        pq.offer(1l);
        long curr = 0;
        for (int i = 1; i <= n; i++) {
            curr = pq.poll();
            while (!pq.isEmpty() && pq.peek() == curr) {
                pq.poll();
            }
            pq.offer(curr * 2);
            pq.offer(curr * 3);
            pq.offer(curr * 5);
        }
        return (int)curr;
    }
}
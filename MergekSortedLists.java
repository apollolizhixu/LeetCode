public class Solution {
    //Time: O(n), Space: O(k)
    Comparator<ListNode> comparator = new Comparator<ListNode>(){
        public int compare(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2.val;
            } else if (l2 == null) {
                return l1.val;
            }
            return l1.val - l2.val;
        }
    };
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, comparator);
        for (ListNode l : lists) {
            if (l != null) {
                q.offer(l);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (q.size() != 0) {
            ListNode cur = q.poll();
            head.next = cur;
            head = head.next;
            cur = cur.next;
            if (cur != null) {
                q.offer(cur);
            }
        }
        return dummy.next;
    }
}
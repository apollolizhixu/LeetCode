/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	//Time: O(n), Space: O(n)
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        RandomListNode pre = dummy, newHead;
        while (head != null) {
            if (!map.containsKey(head)) {
                newHead = new RandomListNode(head.label);
                map.put(head, newHead);
            } else {
                newHead = map.get(head);
            }
            pre.next = newHead;
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    newHead.random = new RandomListNode(head.random.label);
                    map.put(head.random, newHead.random);
                } else {
                    newHead.random = map.get(head.random);
                }
            }
            pre = newHead;
            head = head.next;
        }
        return dummy.next;
    }

    /**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList1(RandomListNode head) {
    	//Time: O(n), Space: O(1)
        if (head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        copy(head);
        copyRandom(dummy.next);
        return split(dummy.next).next;
    }
    public void copy(RandomListNode head) {
        while (head != null) {
            RandomListNode next = head.next;
            RandomListNode newNode = new RandomListNode(head.label);
            head.next = newNode;
            newNode.next = next;
            head = next;
        }
    }
    public void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    public RandomListNode split(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newHead = dummy;
        while (head != null) {
            newHead.next = head.next;
            head.next = head.next.next;
            head = head.next;
            newHead = newHead.next;
        }
        return dummy;
    }
}
}
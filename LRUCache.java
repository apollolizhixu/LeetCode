public class LRUCache {
    HashMap<Integer, ListNode> map;
    int capacity;
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    
    public class ListNode{
        int key;
        int value;
        ListNode next = null;
        ListNode prev = null;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, ListNode>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        //Time: O(1)
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        moveToLast(cur);
        
        return cur.value;
    }
    
    public void set(int key, int value) {
        //Time: O(1)
        ListNode insert = map.containsKey(key) ? 
            map.get(key) : new ListNode(key, value);
        if (get(key) != -1) {
            insert.prev.next = insert.next;
            insert.next.prev = insert.prev;
            insert.value = value;
        }
        map.put(key, insert);
        moveToLast(insert);
        if (map.size() > capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
    }
    public void moveToLast(ListNode key) {
        key.prev = tail.prev;
        key.next = tail;
        tail.prev = key;
        key.prev.next = key;
    }
}
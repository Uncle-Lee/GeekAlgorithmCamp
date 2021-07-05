class LRUCache {

    //定义双向链表
    class ListNode {
        public ListNode pre;
        public ListNode next;
        public int key = -1;
        public int value = -1;

        public ListNode(){}
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    //hashmap用来保存相应的key和可以对应的ListNode
    HashMap<Integer, ListNode> hashMap = new HashMap<Integer, ListNode>();
    //定义保护头尾节点
    ListNode head = new ListNode();
    ListNode end = new ListNode();
    //总容量和当前占用容量
    private int capacity = 0;
    private int currentCapacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = end;
        end.pre = head;
    }
    
    public int get(int key) {
        if(hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            ListNode node = new ListNode(key, value);
            if(currentCapacity >= capacity) {
                removeLast();
            }
            putHead(node);
            hashMap.put(key, node);
            currentCapacity++;
        }
    }

    //容量超过限制，移除最后一个元素
    private void removeLast() {
        ListNode last = end.pre;
        removeNode(last);
        hashMap.remove(last.key);
        currentCapacity--;
    }

    //删除当前节点
    private void removeNode(ListNode node) {
        if(currentCapacity <= 0 || node == null) {
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    //在头部加入一个节点
    private void putHead(ListNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        putHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
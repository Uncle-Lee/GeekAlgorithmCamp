class MyCircularDeque {

    private class ListNode {
        int val;
        ListNode next;
        ListNode previous;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    private int limitCount = 0;
    private int currentCount = 0;
    private ListNode head = null;
    private ListNode end = null;
    private ListNode queue = null;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        limitCount = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (currentCount >= limitCount) {
            return false;
        }
        if (queue == null) {
            queue = new ListNode(value);
            head = queue;
            end = queue;
        } else {
            ListNode listNode = new ListNode(value);
            listNode.next = head;
            head.previous = listNode;
            head = listNode;
        }
        currentCount++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (currentCount >= limitCount) {
            return false;
        }
        if (queue == null) {
            queue = new ListNode(value);
            head = queue;
            end = queue;
        } else {
            ListNode listNode = new ListNode(value);
            listNode.previous = end;
            end.next = listNode;
            end = listNode;
        }
        currentCount++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (queue == null) {
            return false;
        }
        if (currentCount == 1) {
            head = null;
            end = null;
            queue = null;
        } else {
            head = head.next;
            head.previous = null;
            queue = head;
        }
        currentCount--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (queue == null) {
            return false;
        }
        if (currentCount == 1) {
            head = null;
            end = null;
            queue = null;
        } else {
            end = end.previous;
            end.next = null;
        }
        currentCount--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (end == null) {
            return -1;
        }
        return end.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (queue == null) {
            return true;
        } else {
            return false;
        }
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (currentCount >= limitCount) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
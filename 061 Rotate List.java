//链表整体右移k

public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode tail = head;
        int count = 0;
        while(tail.next != null) {
            count++;
            tail = tail.next;
        }
        count++;
        tail.next = head;
        for(int i=1; i<count-k%count; i++) {
            head = head.next;
        }
        ListNode result = head.next;
        head.next = null;
        return result;
    }

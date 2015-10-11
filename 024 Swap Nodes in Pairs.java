//链表中 两个相邻元素互换位置
//代码可精简

public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        ListNode tail = head.next.next;
        head = head.next;
        head.next = temp;
        head.next.next = tail;
        ListNode pre = head.next;
        ListNode point = head.next.next;
        while(point != null && point.next != null) {
            tail = point.next.next;
            temp = point;
            point = point.next;
            pre.next = point;
            point.next = temp;
            point.next.next = tail;
            pre = point.next;
            point = point.next.next;
        }
        return head;
    }

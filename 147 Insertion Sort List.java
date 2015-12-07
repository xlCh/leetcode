//链表的插入排序

public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode current = head;
        ListNode temp;
        while(current != null) {
            temp = newHead;
            while(temp.next != null && temp.next.val < current.val)
                temp = temp.next;
            ListNode next = current.next;
            current.next = temp.next;
            temp.next = current;
            current = next;
        }
        return newHead.next;
    }

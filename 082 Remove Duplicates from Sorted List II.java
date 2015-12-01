//移除链表中的重复元素

public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode node = head;
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        while(node.next != null) {
            if(node.next != null && node.val == node.next.val) {
                while(node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                node = node.next;
                prev.next = node;
                if(node == null) {
                    return newHead.next;
                }
            }
            while(node.next != null && node.val != node.next.val) {
                prev.next = node;
                prev = prev.next;
                node = node.next;
            }
        }
        prev.next = node;
        return newHead.next;
    }

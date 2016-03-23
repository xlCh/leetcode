//https://leetcode.com/problems/reverse-linked-list/
//reverse list
//非递归
ListNode newHead = new ListNode(0), newTemp = newHead;
        ListNode remain = head;
        while(remain != null) {
            ListNode temp = remain;
            remain = remain.next;
            temp.next = newHead.next;
            newHead.next = temp;
        }
        return newHead.next;
//递归
//另一种表达方式 https://leetcode.com/discuss/92750/recursive-method-but-within-single-function
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode nextTail = head.next;
        ListNode nextHead = reverseList(head.next);
        nextTail.next = head;
        head.next = null;
        return nextHead;
    }

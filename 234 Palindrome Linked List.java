//判断链表是否为回文

public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode low = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        ListNode list2 = reverseList(low.next);
        while(list2 != null) {
            if(head.val != list2.val)
                return false;
            head = head.next;
            list2 = list2.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

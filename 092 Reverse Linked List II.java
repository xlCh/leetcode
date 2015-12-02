//倒转链表中m~n位置的元素

public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        ListNode reverseTail = head;
        if(m != 1) {
            for(int i=1; i<m-1; i++)
                reverseTail = reverseTail.next;
            ListNode reversePrev = reverseTail;
            ListNode reverseStart = reverseTail.next;
            for(int i=m-1; i<n+1; i++)
                reverseTail = reverseTail.next;
            reversePrev.next = reverse(reverseStart, reverseTail, n-m+1);
            return head;
        }
        else {
            for(int i=1; i<n+1; i++)
                reverseTail = reverseTail.next;
            return reverse(head, reverseTail, n-m+1);
        }
    }
    
    public ListNode reverse(ListNode reverseStart, ListNode reverseTail, int reverseLength) {
        for(int i=0; i<reverseLength; i++) {
            ListNode temp = reverseStart.next;
            reverseStart.next = reverseTail;
            reverseTail = reverseStart;
            reverseStart = temp;
        }
        return reverseTail;
    }

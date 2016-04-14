//https://leetcode.com/problems/reverse-linked-list-ii/
//倒转链表中m~n位置的元素
//递归解法：https://leetcode.com/discuss/92866/short-c-solution-with-recursion
 public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode rHead = newHead, rTail = newHead;
        for(int i=1; i<m; i++) {
        	rHead = rHead.next;
        	rTail = rTail.next;
        }
        for(int i=m; i<=n+1; i++) {
        	rTail = rTail.next;
        }
        ListNode reverse = rHead.next;
        rHead.next = rTail;
        while(reverse != rTail) {
        	ListNode temp = reverse.next;
        	reverse.next = rHead.next;
        	rHead.next = reverse;
        	reverse = temp;
        }
        //reverse = rTail;
        return newHead.next;
    }

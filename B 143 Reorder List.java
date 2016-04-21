//https://leetcode.com/problems/reorder-list/
//链表重新排序：1->n->2->n-1...
//可以考虑用栈解决 https://leetcode.com/discuss/18875/java-solution-with-stack
public void reorderList(ListNode head) {
    	if(head == null)
    		return;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        ListNode lastHead = reverse(slow);
        slow.next = null;
        ListNode pointer = head;
        while(lastHead != null) {
        	ListNode temp = pointer.next;
        	pointer.next = lastHead;
        	lastHead = lastHead.next;
        	pointer.next.next = temp;
        	pointer = pointer.next.next;
        }
    }
    
    public ListNode reverse(ListNode headPrev) {
    	if(headPrev == null || headPrev.next == null)
    		return null;
    	ListNode pointer = headPrev.next;
    	headPrev.next = null;
    	while(pointer != null) {
    		ListNode temp = pointer.next;
    		pointer.next = headPrev.next;
    		headPrev.next = pointer;
    		pointer = temp;
    	}
    	return headPrev.next;
    }

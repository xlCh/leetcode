//https://leetcode.com/problems/reorder-list/
//链表整体右移k

//笨一点的常规方法
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            length++;
        }
        k %= length;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode fast = newHead, slow = newHead;
        for(int i=0; i<k; i++) {
            
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        newHead.next = slow.next;
        slow.next = null;
        return newHead.next;
    }
}

//简洁一些，先连成环再打断
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

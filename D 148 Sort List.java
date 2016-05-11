//https://leetcode.com/problems/sort-list/
//要求时间O(nlogn)空间O(1)
//严格保证空间O(1) https://leetcode.com/discuss/15420/java-solution-with-strict-o-1-auxiliary-space-complexity
//参考https://leetcode.com/discuss/42289/clean-and-short-merge-sort-solution-in-c
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode anotherHead = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(anotherHead));
    }
    
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        temp.next = null;
        return newHead.next;
    }
}

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
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
    
//更简练一些
public ListNode deleteDuplicates(ListNode head) {
         ListNode newHead = new ListNode(0);
         newHead.next = head;
         ListNode noDup = newHead;
         while(noDup.next != null) {
             if(noDup.next.next != null && noDup.next.next.val == noDup.next.val) {
                 ListNode temp = noDup.next;
                 while(temp != null && temp.val == noDup.next.val) {
                     temp = temp.next;
                 }
                 noDup.next = temp;
             }
             else
                noDup = noDup.next;
         }
         return newHead.next;
    }

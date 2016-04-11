//https://leetcode.com/problems/insertion-sort-list/
//链表的插入排序，但效率不够高
//一种高效的方法，利用链表的特性，免除过多的比较：https://leetcode.com/discuss/92229/7ms-java-solution-with-explanation
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

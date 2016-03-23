//https://leetcode.com/problems/swap-nodes-in-pairs/
//链表中 两个相邻元素互换位置
//递归方法：https://leetcode.com/discuss/90819/a-recursive-solution
public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;
        while(temp.next != null && temp.next.next != null) {
            ListNode save = temp.next;
            temp.next = temp.next.next;
            save.next = temp.next.next;
            temp.next.next = save;
            temp = temp.next.next;
        }
        return newHead.next;
    }

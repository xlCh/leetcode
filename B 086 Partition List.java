//https://leetcode.com/problems/partition-list/
//重新排列链表，小于x的在前，大于等于x的在后
//算较精炼的了
public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode interval = newHead;
        while(interval.next != null && interval.next.val < x)
            interval = interval.next;
        ListNode temp = interval;
        while(temp.next != null) {
            if(temp.next.val < x) {
                ListNode node = temp.next;
                temp.next = node.next;
                node.next = interval.next;
                interval.next = node;
                interval = interval.next;
            }
            else
                temp = temp.next;
        }
        return newHead.next;
    }

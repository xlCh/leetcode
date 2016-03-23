//https://leetcode.com/problems/odd-even-linked-list/
//奇位Node在前，偶位Node在后
//可以少一些temp 先把奇偶挂起来
public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode oddTemp = oddHead, evenTemp = evenHead;
        ListNode temp = evenHead;
        while(temp.next != null) {
            oddTemp.next = temp.next;
            oddTemp = oddTemp.next;
            temp = temp.next;
            if(temp.next == null)
                break;
            evenTemp.next = temp.next;
            evenTemp = evenTemp.next;
            temp = temp.next;
        }
        oddTemp.next = evenHead;
        evenTemp.next = null;
        return oddHead;
    }

//https://leetcode.com/problems/linked-list-cycle/
//判断链表中是否有循环
//另一种方法（若存在环，则reverse list时会访问两次head）：https://leetcode.com/discuss/89213/use-reversed-linklist-to-solve-this-problem
   public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

//https://leetcode.com/problems/add-two-numbers/
//两个数相加 求和 链表形式
//找出长的list并直接操作这个list 会更快 https://leetcode.com/discuss/96766/my-java-solution-3ms-beats-98-68%25-of-java-submission
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return null;
        ListNode newList;
        int addOne = 0;
        if(l1.val + l2.val >= 10) {
            addOne = 1;
            newList = new ListNode(l1.val+l2.val-10);
        }
        else
            newList = new ListNode(l1.val+l2.val);
        ListNode node1 = l1.next;
        ListNode node2 = l2.next;
        ListNode point = newList;
        while(node1 != null && node2 != null) { //改成|| 为空直接置0 可缩短代码行数
            ListNode temp;
            if(node1.val + node2.val + addOne >= 10) {
                temp = new ListNode(node1.val+node2.val+addOne-10);
                addOne = 1;
            }
            else {
                temp = new ListNode(node1.val+node2.val+addOne);
                addOne = 0;
            }
            point.next = temp;
            point = point.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        while(node1 != null) {
             ListNode temp;
            if(node1.val + addOne >= 10) {
                temp = new ListNode(node1.val+addOne-10);
                addOne = 1;
            }
            else {
                temp = new ListNode(node1.val+addOne);
                addOne = 0;
            }
            point.next = temp;
            point = point.next;
            node1 = node1.next;
        }
        while(node2 != null) {
             ListNode temp;
            if(node2.val + addOne >= 10) {
                temp = new ListNode(node2.val+addOne-10);
                addOne = 1;
            }
            else {
                temp = new ListNode(node2.val+addOne);
                addOne = 0;
            }
            point.next = temp;
            point = point.next;
            node2 = node2.next;
        }
        if(addOne == 1) {
            point.next = new ListNode(1);
            point.next.next = null;
        }
        else
            point.next = null;
        return newList;
    }

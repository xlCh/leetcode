//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
//将排好序的链表转换为二叉搜索树（平衡）
//更快：https://leetcode.com/discuss/83856/share-my-java-solution-1ms-very-short-and-concise
public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode fast = head.next, slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        TreeNode node = new TreeNode(slow.next.val);
        slow.next = null;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(temp.next);
        return node;
    }

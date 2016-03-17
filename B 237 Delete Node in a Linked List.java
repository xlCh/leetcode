//https://leetcode.com/problems/delete-node-in-a-linked-list/
//删除链表中的节点node
//注意 如果是c++需要free next节点
public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

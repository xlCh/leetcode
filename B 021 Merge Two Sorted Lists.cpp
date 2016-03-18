//https://leetcode.com/problems/merge-two-sorted-lists/
//合并两个有序链表
//后面步骤的更佳写法：if(ln1) l3->next=ln1;【注意】

ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode * l3head = new ListNode(0);
        ListNode* l3 = l3head;
        ListNode* ln1 = l1, *ln2 = l2;
        while(ln1 != NULL &&  ln2 != NULL) {
            if(ln1->val <= ln2->val) {
                ListNode * temp = new ListNode(ln1->val);
                ln1 = ln1->next;
                l3->next = temp;
                l3 = l3->next;
            }
            else if(ln2->val < ln1->val) {
                ListNode * temp = new ListNode(ln2->val);
                ln2 = ln2->next;
                l3->next = temp;
                l3 = l3->next;
            }
        }
        while(ln1 != NULL) {
            ListNode * temp = new ListNode(ln1->val);
            ln1 = ln1->next;
            l3->next = temp;
            l3 = l3->next;
        }
        while(ln2 != NULL) {
            ListNode * temp = new ListNode(ln2->val);
            ln2 = ln2->next;
            l3->next = temp;
            l3 = l3->next;
        }
        return l3head->next;
    }

//递归解法 不是自己想的 注意
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val) {
            start = l1;
            start.next = mergeTwoLists(l1.next, l2);
        }
        else {
            start = l2;
            start.next = mergeTwoLists(l1, l2.next);
        }
        return start;
    }

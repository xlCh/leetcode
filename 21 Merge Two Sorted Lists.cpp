//合并两个有序链表
//后面步骤的更佳写法：if(ln1) l3->next=ln1;

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

//从链表中移除重复元素

ListNode* deleteDuplicates(ListNode* head) {
        if(head == NULL)
            return NULL;
        ListNode* ln1 = head->next;
        ListNode* ln2 = head;
        while(ln1 != NULL) {
            if(ln1->val == ln2->val) {
                ListNode * temp = ln1;
                ln1 = ln1->next;
                ln2->next = temp->next;
                free(temp);
            }
            else {
                ln1 = ln1->next;
                ln2 = ln2->next;
            }
        }
        return head;
    }

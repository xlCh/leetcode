//移除链表中所有指定值的节点
ListNode* removeElements(ListNode* head, int val) {
        if(head == NULL)
            return NULL;
        ListNode * temp = head;
        ListNode * temp2 = NULL;
        while(head->val == val && head->next != NULL) {
            temp2 = head;
            head = head->next;
            free(temp2);
        }
        if(head->val == val && head->next == NULL) {
            head = NULL;
            return head;
        }
        while(temp->next != NULL) {
            if(temp->next->val == val) {
                temp2 = temp->next;
                temp->next = temp2->next;
                free(temp2);
            }
            else
                temp = temp->next;
        }
        return head;
    }

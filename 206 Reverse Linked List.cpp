//reverse list
//还有递归方法 未实现
ListNode* reverseList(ListNode* head) {
        if(head == NULL || head->next == NULL)
            return head;
        ListNode * current = head;
        ListNode * prev;
        ListNode * next = head->next;
        head->next = NULL;
        while(next != NULL) {
            prev = current;
            current = next;
            next = current->next;
            current->next = prev;
        }
        return current;
    }

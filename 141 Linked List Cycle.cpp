//判断链表中是否有循环

bool hasCycle(ListNode *head) {
        if(head == NULL || head->next == NULL || head->next->next == NULL)
            return false;
        ListNode * temp = head->next;
        ListNode * temp2 = head->next->next;
        while(temp2->next != NULL && temp2->next->next != NULL) {
            if(temp != temp2) {
                temp = temp->next;
                temp2 = temp2->next->next;
            }
            else {
              return true;  
            }
        }
        return false;
    }

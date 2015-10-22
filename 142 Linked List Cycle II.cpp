//判断链表中是否有循环，若有则返回循环开始的地方

ListNode *detectCycle(ListNode *head) {
        if(head == NULL || head->next == NULL || head->next->next == NULL)
            return NULL;
        ListNode * temp = head->next;
        ListNode * temp2 = head->next->next;
        while(temp2->next != NULL && temp2->next->next != NULL) {
            if(temp != temp2) {
                temp = temp->next;
                temp2 = temp2->next->next;
            }
            else {
                int loopNum = 1;
                temp = temp->next;
                temp2 = temp2->next->next;
                while(temp != temp2) {
                    loopNum++;
                    temp = temp->next;
                    temp2 = temp2->next->next;
                }
                temp = head;
                temp2 = head;
                for(int i=0; i< loopNum; i++) {
                    temp2 = temp2->next;
                }
                while(temp != temp2) {
                    temp = temp->next;
                    temp2 = temp2->next;
                }
                return temp;
            }
        }
        return NULL;
    }

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//移除从末尾数第N个节点
//方法有点冗余 如果在head前再加一个node，则不需要这么多判定条件
ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode * n1 = head;
        ListNode * n2 = head;
        bool isFirst = true;
        for(int i=0; i<n; i++)
            n1 = n1->next;
        if(n1 == NULL) {
            ListNode * p = head;
            head = head->next;
            free(p);
            return head;
        }
        while(n1 != NULL) {
            n1 = n1->next;
            if(isFirst)
                isFirst = false;
            else
                n2 = n2->next;
        }
        ListNode * temp = n2->next;
        if(temp != NULL)
            n2->next = temp->next;
        else
            n2->next = NULL;
        free(temp);
        return head;
    }

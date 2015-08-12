//删除链表中的节点node
//注意 不是仅使node = node->next就行
void deleteNode(ListNode* node) {
        if(node == NULL)
            return;
        ListNode * front = node;
        ListNode * rear = node->next;
        while(rear->next != NULL) {
            front->val = rear->val;
            front = rear;
            rear = rear->next;
        }
        front->val = rear->val;
        front->next = NULL;
        free(rear);
    }

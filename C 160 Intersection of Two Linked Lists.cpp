//https://leetcode.com/problems/intersection-of-two-linked-lists/
//找到两个链表的共同节点
//另一种解法[巧妙!]：往复循环 A->B, B->A https://leetcode.com/discuss/88940/simple-c-solution-5-lines


ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int lengthA = 0, lengthB = 0;
        ListNode * a = headA;
        ListNode * b = headB;
        while(a != NULL) {
            a = a->next;
            lengthA++;
        }
        while(b != NULL) {
            b = b->next;
            lengthB++;
        }
        a = headA;
        b = headB;
        if(lengthA > lengthB) {
            int a_b = lengthA - lengthB;
            while(a != NULL && a_b != 0) {
                a = a->next;
                a_b--;
            }
        }
        else if(lengthB > lengthA) {
            int b_a = lengthB - lengthA;
            while(b != NULL && b_a != 0) {
                b = b->next;
                b_a--;
            }
        }
        while(a != NULL && b != NULL) {
            if(a == b)
                return a;
            a = a->next;
            b = b->next;
        }
        return NULL;
    }

//https://leetcode.com/problems/remove-linked-list-elements/
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

//短一些并且快的方法 java
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode temp = preHead;
        while(temp.next != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return preHead.next;
    }

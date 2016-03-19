//https://leetcode.com/problems/implement-queue-using-stacks/
// 用两个栈实现一个队列
// 还可以一个做push栈一个做pop栈
stack<int> st1;
    stack<int> st2;
    // Push element x to the back of queue.
    void push(int x) {
        while(!st1.empty()) {
            int temp = st1.top();
            st1.pop();
            st2.push(temp);
        }
        st2.push(x);
        while(!st2.empty()) {
            int temp = st2.top();
            st2.pop();
            st1.push(temp);
        }
        
    }

    // Removes the element from in front of queue.
    void pop(void) {
        st1.pop();
    }

    // Get the front element.
    int peek(void) {
        return st1.top();
    }

    // Return whether the queue is empty.
    bool empty(void) {
        return st1.empty();
    }

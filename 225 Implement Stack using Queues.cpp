//使用队列实现堆栈
//方法有点麻烦，有只使用一个队列的解法
queue<int> qu1;
    queue<int> qu2;
    // Push element x onto stack.
    void push(int x) {
        qu1.push(x);
    }

    // Removes the element on top of the stack.
    void pop() {
        while(qu1.size() > 1) {
            int temp = qu1.front();
            qu1.pop();
            qu2.push(temp);
        }
        qu1.pop();
        while(!qu2.empty()) {
            int temp = qu2.front();
            qu2.pop();
            qu1.push(temp);
        }
    }

    // Get the top element.
    int top() {
        int top;
        while(!qu1.empty()) {
            int temp = top = qu1.front();
            qu1.pop();
            qu2.push(temp);
        }
        while(!qu2.empty()) {
            int temp = qu2.front();
            qu2.pop();
            qu1.push(temp);
        }
        return top;
    }

    // Return whether the stack is empty.
    bool empty() {
        return qu1.empty();
    }

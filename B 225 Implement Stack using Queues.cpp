//https://leetcode.com/submissions/detail/56711021/
//使用队列实现堆栈
//方法有点麻烦，有只使用一个队列的解法https://leetcode.com/discuss/84233/solutions-about-which-utilizes-queue-others-utilize-queues
//一个队列的解法是在每次push时都rotate一下队列
//q.add(x);
//    for(int i = 1; i < q.size(); i ++) { //rotate the queue to make the tail be the head
//        q.add(q.poll());
//    }
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

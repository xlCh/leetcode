//https://leetcode.com/problems/min-stack/
//Min Stack 比普通栈多一个返回最小值
//维护最小值栈
//更优化的解法：新建自定义链表数据结构 https://leetcode.com/discuss/77734/clean-6ms-java-solution
class MinStack {
public:
    private:
        stack<int> s1;
        stack<int> s2;
    public:
        void push(int x) {
            s1.push(x);
            if (s2.empty() || x <= getMin())  s2.push(x);       
        }
        void pop() {
            if (s1.top() == getMin())  s2.pop();
            s1.pop();
        }
        int top() {
            return s1.top();
        }
        int getMin() {
            return s2.top();
        }
};

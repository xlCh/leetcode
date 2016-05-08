//https://leetcode.com/problems/flatten-nested-list-iterator/
//嵌套列表迭代器
//不用到栈的方法：https://leetcode.com/discuss/101021/no-stack-just-play-with-pointer
//调用时需要输出所有 所以可以将flatten提前到构造器中，否则可以放在hasNext中。注意hasNext不能根据判断stack.empty()得到，例如情况[[],[1],[]]
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    public Stack<NestedInteger> stack = new Stack<NestedInteger>();
    public Queue<Integer> wholeQueue = new LinkedList<Integer>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i=nestedList.size()-1; i>=0; i--) {
            stack.push(nestedList.get(i));
        }
        while(!stack.isEmpty()) {
            NestedInteger temp = stack.pop();
            if(temp.isInteger()) {
                wholeQueue.offer(temp.getInteger());
            }
            else {
                for(int i=temp.getList().size()-1; i>=0; i--) {
                    stack.push(temp.getList().get(i));
                }
            }
        }
    }

    @Override
    public Integer next() {
        return wholeQueue.poll();
    }

    @Override
    public boolean hasNext() {
        return !wholeQueue.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

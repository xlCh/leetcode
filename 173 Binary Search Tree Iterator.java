//实现二叉搜索树的next和hasNext 时间复杂度为O(1) 空间复杂度为O(h)

public class BSTIterator {

    Stack<TreeNode> valStack;

    public BSTIterator(TreeNode root) {
        valStack = new Stack<TreeNode>();
        setNext(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !valStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(!hasNext())
            return -1;
        TreeNode temp = valStack.pop();
        int result = temp.val;
        setNext(temp.right);
        return result;
    }
    
    public void setNext(TreeNode root) {
        while(root != null) {
            valStack.push(root);
            root = root.left;
        }
    }
}

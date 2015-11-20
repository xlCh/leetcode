//计算完全二叉树中结点的个数
//discuss中的递归解法
//但将1 << leftHeight改成Math.pow会超时

public class Solution {
    public int countNodes(TreeNode root) {
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if(leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    public int getLeftHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
    
    public int getRightHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            height++;
            root = root.right;
        }
        return height;
    }
}

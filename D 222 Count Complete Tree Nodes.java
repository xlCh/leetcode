//https://leetcode.com/problems/count-complete-tree-nodes/
//计算完全二叉树中结点的个数
//另一种递归解法 利用完全二叉树左右是否为满二叉树：https://leetcode.com/discuss/73892/a-very-clear-recursive-solution-isnt-it
//更简洁的版本：https://leetcode.com/discuss/38930/concise-java-solutions-o-log-n-2
//三种不同解法：https://leetcode.com/discuss/38930/concise-java-solutions-o-log-n-2
//最快的解法：https://leetcode.com/discuss/73735/my-java-solution-with-explanation-which-beats-99%25
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

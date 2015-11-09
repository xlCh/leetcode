//验证二叉搜索树的正确性 注意在递归过程中保存最小值和最大值

public class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}

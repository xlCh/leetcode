//https://leetcode.com/problems/validate-binary-search-tree
//验证二叉搜索树的正确性 注意在递归过程中保存最小值和最大值
//可回避long问题 https://leetcode.com/discuss/73291/1-ms-java-solution-using-recursion
//中序遍历 迭代做法 https://leetcode.com/discuss/22234/my-java-inorder-iteration-solution
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

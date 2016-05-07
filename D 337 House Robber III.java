//https://leetcode.com/problems/house-robber-iii/
//结构为树，不能偷相连的人家（即父子）
//详解 https://leetcode.com/discuss/91899/step-by-step-tackling-of-the-problem
//参考https://leetcode.com/discuss/99216/very-simple-with-java-1-ms
public int rob(TreeNode root) {
        if(root == null)
            return 0;
        helper(root);
        return root.val;
    }
    
    public int helper(TreeNode root) {
        if(root == null)
            return 0;
        int pre = 0;
        root.val += helper(root.left) + helper(root.right);
        if(root.left != null)
            pre += root.left.val;
        if(root.right != null)
            pre += root.right.val;
        root.val = Math.max(pre, root.val);
        return pre;
    }

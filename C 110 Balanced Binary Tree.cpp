//https://leetcode.com/problems/balanced-binary-tree/
//判断二叉树是否平衡
//递归解法，有优化空间 可以避免两个递归函数 https://leetcode.com/discuss/86239/java-1ms-solution
bool isBalanced(TreeNode* root) {
        if(root == NULL)
            return true;
        int leftDepth = maxDepth(root->left);
        int rightDepth = maxDepth(root->right);
        if(leftDepth-rightDepth > 1 || rightDepth-leftDepth > 1)
            return false;
        return isBalanced(root->left) && isBalanced(root->right);
    }
    
    int maxDepth(TreeNode* root) {
        if(root == NULL)
            return 0;
        int leftDepth = maxDepth(root->left);
        int rightDepth = maxDepth(root->right);
        return (leftDepth>rightDepth?leftDepth:rightDepth)+1;
    }

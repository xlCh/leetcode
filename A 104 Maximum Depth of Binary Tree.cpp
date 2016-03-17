//https://leetcode.com/problems/maximum-depth-of-binary-tree/
//树最大高度 递归方法

int maxDepth(TreeNode* root) {
    if(root == NULL)
        return 0;
    int leftDepth = maxDepth(root->left);
    int rightDepth = maxDepth(root->right);
    return (leftDepth>rightDepth?leftDepth:rightDepth)+1;
}

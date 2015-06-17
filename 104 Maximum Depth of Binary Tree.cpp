//树最大高度 递归方法
//非递归方法待补充
int maxDepth(TreeNode* root) {
    if(root == NULL)
        return 0;
    int leftDepth = maxDepth(root->left);
    int rightDepth = maxDepth(root->right);
    return (leftDepth>rightDepth?leftDepth:rightDepth)+1;
}

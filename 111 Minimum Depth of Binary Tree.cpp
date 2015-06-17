//到叶子的最短路径
//非递归方法未完成
//注意是到叶子 所以要判断是否为叶子
int minDepth(TreeNode* root) {
        if(root == NULL)
            return 0;
        int leftDepth = minDepth(root->left);
        int rightDepth = minDepth(root->right);
        if(leftDepth == 0)
            return rightDepth+1;
        else if(rightDepth == 0)
            return leftDepth+1;
        else
            return (leftDepth<rightDepth?leftDepth:rightDepth)+1;
    }

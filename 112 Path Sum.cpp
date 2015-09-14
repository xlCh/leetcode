//树中是否有和为sum的一条路径，递归解法
//非递归解法未实现

bool hasPathSum(TreeNode* root, int sum) {
        if(root == NULL)
            return false;
        if(root->left == NULL && root->right == NULL) {
            return root->val==sum?true:false;
        }
        return(hasPathSum(root->left, sum-root->val) || hasPathSum(root->right, sum-root->val));
    }

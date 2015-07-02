//反转二叉树 递归解法
TreeNode* invertTree(TreeNode* root) {
        if(root != NULL) {
            invertTree(root->left);
            invertTree(root->right);
            TreeNode* temp = root->left;
            root->left = root->right;
            root->right = temp;
        }
        return root;
    }

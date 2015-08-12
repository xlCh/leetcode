//找出二叉搜索树中两个节点最近的共同祖先
//递归解法
TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL)
            return NULL;
        else if((p->val < root->val && q->val > root->val) || (p->val > root->val && q->val < root->val) || p->val == root->val || q->val == root->val)
            return root;
        else if(p->val < root->val && q->val < root->val)
            return lowestCommonAncestor(root->left, p, q);
        else if(p->val > root->val && q->val > root->val)
            return lowestCommonAncestor(root->right, p, q);
    }

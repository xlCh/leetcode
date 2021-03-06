//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
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

//非递归解法 与递归有些相似
while(true){
      if((root.val-p.val)*(root.val-q.val) <= 0) return root;
      root = p.val < root.val ? root.left : root.right;
    }

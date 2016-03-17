//判断两棵树是否相同
//只实现了递归形式，非递归形式略

bool isSameTree(TreeNode* p, TreeNode* q) {
        if(p == NULL && q == NULL)
            return true;
        else if(p == NULL || q == NULL || p->val != q->val)
            return false;
        else 
            return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }

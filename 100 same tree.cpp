//判断两棵树是否相同
//只实现了递归形式，非递归待实现

bool isSameTree(TreeNode* p, TreeNode* q) {
        if(p == NULL && q == NULL)
            return true;
        //下面这句可精简为p==NULL或q==NULL
        else if((p != NULL && q == NULL) || (p == NULL && q != NULL))
            return false;
        else if(p->val != q->val)
            return false;
        else 
            return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }

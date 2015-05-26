//判断树是否对称
//使用递归方法，非递归暂未实现
bool isSymmetric(TreeNode* root) {
        if(root == NULL)
            return true;
        return areSymmetric(root->left, root->right);
    }
    
    bool areSymmetric(TreeNode* t1, TreeNode* t2) {
        if(t1 == NULL && t2 == NULL)
            return true;
        else if(t1 == NULL || t2 == NULL)
            return false;
        else if(t1->val != t2->val)
            return false;
        else {
            return areSymmetric(t1->left, t2->right) && areSymmetric(t1->right, t2->left);
        }
    }

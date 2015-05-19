//未完成 还有错
class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if(root == NULL) {
            return false;
        }
        stack<TreeNode*> st;
        TreeNode * temp;
        int count = 0;
        st.push(root);
        while(!st.empty()) {
            temp = st.top();
            st.pop();
            if (temp == NULL)
                continue;
            count += temp->val;
            if(count == sum && temp->right == NULL && temp->left == NULL)
                return true;
            if(temp->right != NULL) {
                st.push(temp->right);
            }
            if(temp->left != NULL) {
                st.push(temp->left);
            }
            if(temp->right == NULL && temp->left == NULL) {
                count -= temp->val;
            }
        }
        return false;
    }
};

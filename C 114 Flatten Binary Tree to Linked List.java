//https://leetcode.com/problems/flatten-binary-tree-to-linked-list
//将二叉树转换为只含有向右的指针（相当于前序遍历的顺序）
//多种实现形式
public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) {
            root = root.right;
        }
        root.right = tempRight;
    }

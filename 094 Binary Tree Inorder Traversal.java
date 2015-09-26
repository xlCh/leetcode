//二叉树的中序遍历 递归解法

public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traverse = new ArrayList<Integer>();
        inorder(root, traverse);
        return traverse;
    }
    
    public void inorder(TreeNode root, List<Integer> traverse) {
        if(root == null)
            return;
        inorder(root.left, traverse);
        traverse.add(root.val);
        inorder(root.right, traverse);
    }

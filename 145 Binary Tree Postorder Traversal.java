//二叉树的后序遍历 递归解法

public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traverse = new ArrayList<Integer>();
        postorder(root, traverse);
        return traverse;
    }
    
    public void postorder(TreeNode root, List<Integer> traverse) {
        if(root == null)
            return;
        postorder(root.left, traverse);
        postorder(root.right, traverse);
        traverse.add(root.val);
    }

//二叉树的前序遍历 递归解法

public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traverse = new ArrayList<Integer>();
        preorder(root, traverse);
        return traverse;
    }
    
    public void preorder(TreeNode root, List<Integer> traverse) {
        if(root == null)
            return;
        traverse.add(root.val);
        preorder(root.left, traverse);
        preorder(root.right, traverse);
    }

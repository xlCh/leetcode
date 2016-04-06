//https://leetcode.com/problems/binary-tree-preorder-traversal/
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


//非递归解法
public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
			TreeNode temp = stack.pop();
			result.add(temp.val);
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
		return result;
    }
